package com.product.product_api.repositories;

import com.product.product_api.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    
    Optional<Product> findByProductIdentifier(String productIdentifier);
    
    @Query("{'category.id': ?0}")
    List<Product> findByCategoryId(String categoryId);
    
    @NonNull
    Page<Product> findAll(@NonNull Pageable pageable);
}
