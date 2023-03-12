package com.presentacion.products.repository;

import com.presentacion.products.documents.Produts;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Produts,String> {

}
