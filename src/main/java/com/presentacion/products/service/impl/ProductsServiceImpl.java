package com.presentacion.products.service.impl;

import com.presentacion.products.model.dto.request.ProductsRequest;
import com.presentacion.products.model.dto.response.ProductsResponse;
import com.presentacion.products.model.thirthparthy.Customer;
import com.presentacion.products.model.thirthparthy.ListCustomer;
import com.presentacion.products.repository.ProductsRepository;
import com.presentacion.products.service.ProductsService;
import com.presentacion.products.util.ProductsBuilder;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que contiene la lógica del Produts respecto al CRUD
 */
@Service
@Slf4j
//@AllArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    RestTemplate clienteRest;

    @Autowired
    private ProductsRepository productsRepository;

    @Value("${service-customer.ribbon.listOfServer}")
    private String dataCustomer;

    /***
     * Este método listará todos los Products
     * @return lista de Produts (Produts)
     */
    @Override
    public Observable<ProductsResponse> findAllProducts() {
       return Observable.fromIterable(productsRepository.findAll())
               .map(products -> ProductsBuilder.productEntityToProductResponse(products))
               .subscribeOn(Schedulers.io());
    }

    /***
     * Este método listará los Products
     * @return Lista de Products
    **/
    @Override
    public Observable<ProductsResponse> findAllByNumberDocument(Integer numberDocument) {
       return findAllProducts()
               .filter(productsResponse -> productsResponse.getNumberDocument().equals(numberDocument))
               .subscribeOn(Schedulers.io());
    }

    /***
     * Este método listará los Produts
     * @return Produts (Produts)
     **/
    @Override
    public Single<ProductsResponse> saveProduct(ProductsRequest request) {
        return Single.just(ProductsBuilder.ProductsRequestToProductEntity(request))
                //.filter(products -> products.getNumberDocument().equals(getCustomer().getNumberDocument()))
                .filter(products -> {
                    System.out.println(Arrays.stream(getCustomer()).collect(Collectors.toList()));
                    return products.getNumberDocument() != null;

                })
                .map(products -> productsRepository.save(products))
                .map(products -> ProductsBuilder.productEntityToProductResponse(products))
                .subscribeOn(Schedulers.io())
                .toSingle();

    }

    /***
     * Este método eliminará a los Produts
     **/
    @Override
    public Completable delete() {
        log.info("Se eliminan todos los registros");
         productsRepository.deleteAll();
         return Completable.complete();
    }

    /***
     * Este método ayuda a obtener los datos de los clientes
     **/
    public Customer[]  getCustomer() {
        log.info("Extrayendo registros del Cliente");
        Customer[] customer= clienteRest.getForObject(dataCustomer, Customer[].class);
        return customer;
    }
}
