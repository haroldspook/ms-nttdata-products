package com.presentacion.products.util;

import com.presentacion.products.model.dto.request.ProductsRequest;
import com.presentacion.products.model.dto.response.ProductsResponse;
import com.presentacion.products.model.entity.Products;

public class ProductsBuilder {
    public final static Products ProductsRequestToProductEntity (ProductsRequest request){
        return Products.builder()
                .id(request.getId())
                .numberDocument(request.getNumberDocument())
                .active(request.getActive())
                .pasive(request.getPasive())
                .createAt(request.getCreateAt())
                .build();
    }

    public static ProductsResponse productEntityToProductResponse(Products model){
        return ProductsResponse.builder()
                .id(model.getId())
                .numberDocument(model.getNumberDocument())
                .active(model.getActive())
                .pasive(model.getPasive())
                .createAt(model.getCreateAt())
                .build();
    }

}
