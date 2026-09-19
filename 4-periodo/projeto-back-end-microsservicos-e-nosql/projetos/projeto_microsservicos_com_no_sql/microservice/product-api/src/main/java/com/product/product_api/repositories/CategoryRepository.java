package com.product.product_api.repositories;

import com.product.product_api.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    
    @NonNull
    Page<Category> findAll(@NonNull Pageable pageable);
}
