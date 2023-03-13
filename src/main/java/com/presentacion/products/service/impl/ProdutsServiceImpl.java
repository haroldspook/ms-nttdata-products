package com.presentacion.products.service.impl;

import com.presentacion.products.documents.Produts;
import com.presentacion.products.model.Customer;
import com.presentacion.products.model.ListCustomer;
import com.presentacion.products.repository.ProdutsRepository;
import com.presentacion.products.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que contiene la lógica del Produts respecto al CRUD
 */
@Service
public class ProdutsServiceImpl implements ProductsService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private ProdutsRepository customerRepository;

    final String ROOT_URI = "https://localhost:8080/springData/person";

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

        ResponseEntity<Customer[]> responseCustomer = restTemplate.getForEntity(ROOT_URI, Customer[].class);
        List<Customer> listCustomer = Arrays.stream(responseCustomer.getBody()).collect(Collectors.toList());
        listCustomer.stream()
                .filter(c -> {
                    if(c.getNumberDocument() == produts.getNumberDocument()){
                        customerRepository.save(produts);
                        return true;
                    }else {
                        System.out.println("no registró");
                        return false;
                    }

                }).collect(Collectors.toList());

        return customerRepository.save(produts);
    }

    /***
     * Este método eliminará a los Produts
     **/
    @Override
    public void delete() {
        customerRepository.deleteAll();
    }

    @Override
    public List<Customer> findAllCustomer() {
        return null;
    }
}
