package com.presentacion.products.service;


import com.presentacion.products.documents.Produts;

import java.util.List;

/**
 * Interfaz donde definimos los métodos a implementar
 */
public interface ProductsService {
    List<Produts> findAll();
    List<Produts> findAllById(Integer numberDocument);
    Produts save(Produts customer);
    void delete();
}
