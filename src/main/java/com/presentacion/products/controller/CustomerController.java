package com.presentacion.products.controller;

import com.presentacion.products.documents.Produts;
import com.presentacion.products.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que representa al controllador
 */
@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    /**
     * Inyectamos la clase ProductServiceImpl
     */
    @Autowired
    private CustomerServiceImpl customerService;

    /**
     * Método que listará los Product (Product)
     * @return Lista de Product Product
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Produts>>getCustomer(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    /**
     * Metodo que eliminará todos los Product (Product)
     */
    @DeleteMapping
    @ResponseBody
    public ResponseEntity<HttpStatus>deleteListCustomer(){
        customerService.delete();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Método que registrará los Products
     * @param produts
     * @return El mismo Product para ver su inserción
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Produts>saveCustomer(@RequestBody Produts produts){
        return new ResponseEntity<Produts>(customerService.save(produts), HttpStatus.OK);

    }

}
