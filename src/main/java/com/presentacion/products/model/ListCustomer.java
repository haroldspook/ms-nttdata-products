package com.presentacion.products.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListCustomer {
    private List<Customer> customerList = new ArrayList<>();
}
