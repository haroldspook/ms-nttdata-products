package com.presentacion.web.expose;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.google.gson.Gson;
import com.presentacion.products.model.dto.request.ProductsRequest;
import com.presentacion.products.model.dto.response.ProductsResponse;
import com.presentacion.products.service.ProductsService;
import com.presentacion.products.util.TestUtil;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class ProductsControllerTest {
    @InjectMocks
    private ProductsController productsController;

    @Mock
    private ProductsService productsService;


    private static final Gson GSON = new Gson();

    @Before
    public void setup(){
        initMocks(this);
    }

  @Test
  @DisplayName("Obtiene todos  los datos de los Productos")
  public void returnListProductsResponseWhenGetProductsIsOk() {
        ProductsResponse productsResponse = GSON.fromJson(TestUtil.readJsonFileToString("mock/products_response.json"),
                ProductsResponse.class);
        when(productsService.findAllProducts()).thenReturn(Observable.just(productsResponse));
        TestObserver<ProductsResponse> testObserver = productsController.getAllProducts().test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }

  @Test
  @DisplayName("Elimina toda la lista de los  prodcutos")
  public void returnOkWhenDeleteListProducts() {
        when(productsService.delete()).thenReturn(Completable.complete());
        TestObserver<Void> testObserver = productsController.deleteListProducts().test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }

   @Test
   @DisplayName("Cuando se guardan correctamente los datos de los productos")
   public void returnSuccessWhenSaveOk() {
        ProductsRequest productsRequest = GSON.fromJson(TestUtil.readJsonFileToString("mock/products_request.json"),
            ProductsRequest.class);
        ProductsResponse productsResponse = GSON.fromJson(TestUtil.readJsonFileToString("mock/products_response.json"),
                ProductsResponse.class);
        when(productsService.saveProduct(any())).thenReturn(Single.just(productsResponse));
        TestObserver<ProductsResponse> testObserver = productsController.saveProduct(productsRequest).test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }
}