package com.product.product_api.models.dto;

import com.product.product_api.models.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotBlank(message = "Product Identifier é obrigatório")
    private String productIdentifier;
    
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    
    @NotNull(message = "Preço é obrigatório")
    private Double preco;
    
    private String descricao;
    
    @NotNull(message = "Categoria é obrigatória")
    private Category category;
}
