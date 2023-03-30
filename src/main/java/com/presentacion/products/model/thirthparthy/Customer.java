package com.presentacion.products.model.thirthparthy;

import lombok.Data;

import java.util.Date;

@Data
public class Customer {
    private Long id;
    private String name;
    private String last;
    private Integer age;
    private Boolean status;
    private String typeDocument;
    private Integer numberDocument;
    private Integer typeCustomer;
    private Date createAt;
}
