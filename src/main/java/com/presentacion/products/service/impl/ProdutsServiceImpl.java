package com.presentacion.products.service.impl;

import com.presentacion.products.documents.Produts;
import com.presentacion.products.repository.ProdutsRepository;
import com.presentacion.products.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que contiene la lógica del Produts respecto al CRUD
 */
@Service
public class ProdutsServiceImpl implements ProductsService {

    @Autowired
    private ProdutsRepository customerRepository;

    /***
     * Este método listará todos los Products
     * @return lista de Produts (Produts)
     */
    @Override
    public List<Produts> findAll() {
       return customerRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    /***
     * Este método listará los Products
     * @return Lista de Products
    **/
    @Override
    public List<Produts> findAllById(Integer numberDocument) {
       return customerRepository.findAll()
               .stream()
               .collect(Collectors.toList());
    }

    /***
     * Este método listará los Produts
     * @return Produts (Produts)
     **/
    @Override
    public Produts save(Produts produts) {
        return customerRepository.save(produts);
    }

    /***
     * Este método eliminará a los Produts
     **/
    @Override
    public void delete() {
        customerRepository.deleteAll();
    }
}
