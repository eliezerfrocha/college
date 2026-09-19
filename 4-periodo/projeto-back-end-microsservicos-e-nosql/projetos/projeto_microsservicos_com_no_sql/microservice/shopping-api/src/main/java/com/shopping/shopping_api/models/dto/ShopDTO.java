package com.shopping.shopping_api.models.dto;

import com.example.dto.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopDTO {

    @NotBlank(message = "User Identifier é obrigatório")
    private String userIdentifier;
    
    @NotEmpty(message = "Items são obrigatórios")
    private List<Item> items;
}
