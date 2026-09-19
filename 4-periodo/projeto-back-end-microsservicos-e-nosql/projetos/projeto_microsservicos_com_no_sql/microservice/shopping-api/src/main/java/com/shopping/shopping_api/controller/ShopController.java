package com.shopping.shopping_api.controller;

import com.shopping.shopping_api.models.Shop;
import com.shopping.shopping_api.models.dto.ShopDTO;
import com.shopping.shopping_api.services.ShopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shopping")
public class ShopController {
    
    @Autowired
    private ShopService shopService;
    
    @GetMapping
    public List<Shop> getAllShops() {
        return shopService.getAllShops();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable @NonNull String id) {
        Optional<Shop> shop = shopService.getShopById(id);
        return shop.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/shopByUser")
    public List<Shop> getShopsByUser(@RequestParam String userIdentifier) {
        return shopService.getShopsByUser(userIdentifier);
    }
    
    @GetMapping("/shopByDate")
    public List<Shop> getShopsByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return shopService.getShopsByDate(startDate, endDate);
    }
    
    @GetMapping("/product/{productIdentifier}")
    public List<Shop> getShopsByProductIdentifier(@PathVariable String productIdentifier) {
        return shopService.getShopsByProductIdentifier(productIdentifier);
    }
    
    @GetMapping("/search")
    public List<Shop> getShopsByFilter(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                     @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
                                     @RequestParam(required = false) Double minValue,
                                     @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String dataInicio,
                                     @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String dataFim,
                                     @RequestParam(required = false) Double valorMinimo) {
        
        LocalDateTime start = startDate;
        LocalDateTime end = endDate;
        Double min = minValue;
        
        if (dataInicio != null && dataFim != null) {
            start = LocalDateTime.parse(dataInicio + "T00:00:00");
            end = LocalDateTime.parse(dataFim + "T23:59:59");
        }
        
        if (valorMinimo != null) {
            min = valorMinimo;
        }
        
        if (start != null && end != null && min != null) {
            return shopService.getShopsByFilter(start, end, min);
        } else if (start != null && end != null) {
            return shopService.getShopsByDate(start, end);
        } else {
            return shopService.getAllShops();
        }
    }
    
    @GetMapping("/report")
    public List<Shop> getReportByDate(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
                                    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String dataInicio,
                                    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String dataFim) {
        
        LocalDateTime start = startDate;
        LocalDateTime end = endDate;
        
        if (dataInicio != null && dataFim != null) {
            start = LocalDateTime.parse(dataInicio + "T00:00:00");
            end = LocalDateTime.parse(dataFim + "T23:59:59");
        }
        
        if (start != null && end != null) {
            return shopService.getReportByDate(start, end);
        } else {
            return shopService.getAllShops();
        }
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Shop createShop(@RequestBody @Valid ShopDTO shopDTO) {
        return shopService.saveShop(shopDTO);
    }
}
