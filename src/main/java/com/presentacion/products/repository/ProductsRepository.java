package com.presentacion.products.repository;

import com.presentacion.products.model.entity.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends MongoRepository<Products,Long> {

}
