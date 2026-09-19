package com.shopping.shopping_api.repositories;

import com.shopping.shopping_api.models.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShopRepository extends MongoRepository<Shop, String> {
    
    List<Shop> findByUserIdentifier(String userIdentifier);
    
    @Query("{'date': {$gte: ?0, $lte: ?1}}")
    List<Shop> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    
    @Query("{'items.productIdentifier': ?0}")
    List<Shop> findByProductIdentifier(String productIdentifier);
    
    @Query("{'date': {$gte: ?0, $lte: ?1}, 'total': {$gte: ?2}}")
    List<Shop> findByDateBetweenAndTotalGreaterThanEqual(LocalDateTime startDate, LocalDateTime endDate, Double minValue);
    
    @NonNull
    Page<Shop> findAll(@NonNull Pageable pageable);
}
