package com.presentacion.products.repository;

import com.presentacion.products.model.entity.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepository extends MongoRepository<Products,Long> {

}
