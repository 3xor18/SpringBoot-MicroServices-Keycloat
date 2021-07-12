package com.ms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
