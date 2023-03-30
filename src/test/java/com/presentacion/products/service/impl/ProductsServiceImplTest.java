package com.presentacion.products.service.impl;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.google.gson.Gson;
import com.presentacion.products.model.dto.response.ProductsResponse;
import com.presentacion.products.model.entity.Products;
import com.presentacion.products.repository.ProductsRepository;
import com.presentacion.products.util.TestUtil;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductsServiceImplTest {

    @InjectMocks
    private ProductsServiceImpl productsService;
    @Mock
    private ProductsRepository productsRepository;
    @Mock
    private RestTemplate clienteRest;;

    private static final Gson GSON = new Gson();
    private static final Integer DOCUMENT_NUMBER = Integer.valueOf(77777777);


    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    @DisplayName("Obtiene todos  los datos de los Clientes")
    void findAllProducts() {
        Products products = GSON.fromJson(TestUtil.readJsonFileToString("mock/products_response.json"),
                Products.class);
        List<Products> productsList = new ArrayList<>();
        productsList.add(products);

        when(productsRepository.findAll()).thenReturn(productsList);
        TestObserver<ProductsResponse> testObserver = productsService.findAllProducts().test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }

    @Test
    @DisplayName("Obtiene todos  los datos de los Productos acorde al numero de documento")
    public void returnListProductsResponseWhenfindAllByNumberDocument() {
        Products products = GSON.fromJson(TestUtil.readJsonFileToString("mock/products_response.json"),
                Products.class);
        List<Products> productsList = new ArrayList<>();
        productsList.add(products);

        when(productsRepository.findAll()).thenReturn(productsList);
        TestObserver<ProductsResponse> testObserver = productsService.findAllByNumberDocument(DOCUMENT_NUMBER).test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }

    @Test
    @DisplayName("Elimina toda la lista de Productos")
    public void returnOkWhenDeleteListProducts(){
        TestObserver<Void> testObserver = productsService.delete().test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }

}