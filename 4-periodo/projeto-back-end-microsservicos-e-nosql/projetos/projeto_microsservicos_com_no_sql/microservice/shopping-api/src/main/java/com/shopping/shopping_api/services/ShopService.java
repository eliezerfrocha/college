package com.shopping.shopping_api.services;

import com.shopping.shopping_api.models.Shop;
import com.shopping.shopping_api.models.dto.ShopDTO;
import com.shopping.shopping_api.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService {
    
    @Autowired
    private ShopRepository shopRepository;
    
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }
    
    public Optional<Shop> getShopById(@NonNull String id) {
        return shopRepository.findById(id);
    }
    
    public List<Shop> getShopsByUser(String userIdentifier) {
        return shopRepository.findByUserIdentifier(userIdentifier);
    }
    
    public List<Shop> getShopsByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return shopRepository.findByDateBetween(startDate, endDate);
    }
    
    public List<Shop> getShopsByProductIdentifier(String productIdentifier) {
        return shopRepository.findByProductIdentifier(productIdentifier);
    }
    
    public List<Shop> getShopsByFilter(LocalDateTime startDate, LocalDateTime endDate, Double minValue) {
        return shopRepository.findByDateBetweenAndTotalGreaterThanEqual(startDate, endDate, minValue);
    }
    
    public List<Shop> getReportByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return shopRepository.findByDateBetween(startDate, endDate);
    }
    
    @NonNull
    public Page<Shop> getAllShopsPageable(@NonNull Pageable pageable) {
        return shopRepository.findAll(pageable);
    }
    
    @NonNull
    public Shop saveShop(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setUserIdentifier(shopDTO.getUserIdentifier());
        shop.setDate(LocalDateTime.now());
        shop.setItems(shopDTO.getItems());
        
        // Calcular total
        Double total = shopDTO.getItems().stream()
                .mapToDouble(item -> item.getPrice().doubleValue())
                .sum();
        shop.setTotal(total);
        
        return shopRepository.save(shop);
    }
}
