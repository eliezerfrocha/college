package com.shopping.shopping_api.models.converter;

import com.shopping.shopping_api.models.Shop;
import com.shopping.shopping_api.models.dto.ShopDTO;
import java.time.LocalDateTime;
public class DTOConverter {
    public static ShopDTO convert(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setItems(shop.getItems());
        return shopDTO;
    }
    
    public static Shop convert(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setUserIdentifier(shopDTO.getUserIdentifier());
        shop.setItems(shopDTO.getItems());
        shop.setDate(LocalDateTime.now());
        shop.setTotal(shopDTO.getItems().stream()
                .mapToDouble(item -> item.getPrice().doubleValue())
                .sum());
        return shop;
    }
}
