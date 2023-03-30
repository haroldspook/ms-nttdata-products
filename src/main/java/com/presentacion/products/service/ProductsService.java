package com.presentacion.products.service;


import com.presentacion.products.model.dto.request.ProductsRequest;
import com.presentacion.products.model.dto.response.ProductsResponse;
import com.presentacion.products.model.thirthparthy.Customer;
import io.reactivex.Single;
import io.reactivex.Completable;
import io.reactivex.Observable;

import java.util.List;

/**
 * Interfaz donde definimos los métodos a implementar
 */
public interface ProductsService {
    Observable<ProductsResponse> findAllProducts();
    Observable<ProductsResponse> findAllByNumberDocument(Integer numberDocument);
    Single<ProductsResponse> saveProduct(ProductsRequest request);
    Completable delete();
}
