package com.product.product_api.services;

import com.product.product_api.models.Product;
import com.product.product_api.models.dto.ProductDTO;
import com.product.product_api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Optional<Product> getProductById(@NonNull String id) {
        return productRepository.findById(id);
    }
    
    public Optional<Product> getProductByProductIdentifier(String productIdentifier) {
        return productRepository.findByProductIdentifier(productIdentifier);
    }
    
    public List<Product> getProductsByCategoryId(String categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
    
    @NonNull
    public Page<Product> getAllProductsPageable(@NonNull Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    
    @NonNull
    public Product saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductIdentifier(productDTO.getProductIdentifier());
        product.setNome(productDTO.getNome());
        product.setPreco(productDTO.getPreco());
        product.setDescricao(productDTO.getDescricao());
        product.setCategory(productDTO.getCategory());
        
        return productRepository.save(product);
    }
    
    public Product updateProduct(@NonNull String id, ProductDTO productDTO) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setNome(productDTO.getNome());
            product.setPreco(productDTO.getPreco());
            product.setDescricao(productDTO.getDescricao());
            product.setCategory(productDTO.getCategory());
            
            return productRepository.save(product);
        }
        return null;
    }
    
    public boolean deleteProduct(@NonNull String id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
