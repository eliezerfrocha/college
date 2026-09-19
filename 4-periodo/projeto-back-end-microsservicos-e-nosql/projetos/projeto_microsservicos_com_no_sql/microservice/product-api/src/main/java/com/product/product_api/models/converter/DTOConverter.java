package com.product.product_api.models.converter;

import com.product.product_api.models.Category;
import com.product.product_api.models.Product;
import com.example.dto.CategoryDTO;
import com.example.dto.ProductDTO;
public class DTOConverter {
    public static CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setNome(category.getNome());
        return categoryDTO;
    }

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductIdentifier(product.getProductIdentifier());
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setDescricao(product.getDescricao());
        
        Category category = product.getCategory();
        productDTO.setCategory(com.example.dto.Category.valueOf(category.getNome().toUpperCase()));
        
        return productDTO;
    }
}
