package com.presentacion.products.model;

import lombok.Data;

@Data
public class Customer {
    private String id;
    private String name;
    private String last;
    private Integer age;
    private Boolean status;
    private String typeDocument;
    private Integer numberDocument;
    private Integer typeCustomer;
}
