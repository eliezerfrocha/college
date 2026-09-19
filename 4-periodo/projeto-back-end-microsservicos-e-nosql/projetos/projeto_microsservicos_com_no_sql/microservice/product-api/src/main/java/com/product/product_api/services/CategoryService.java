package com.product.product_api.services;

import com.product.product_api.models.Category;
import com.product.product_api.models.dto.CategoryDTO;
import com.product.product_api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    @NonNull
    public Page<Category> getAllCategoriesPageable(@NonNull Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
    
    @NonNull
    public Category saveCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setNome(categoryDTO.getNome());
        return categoryRepository.save(category);
    }
    
    public Category updateCategory(@NonNull String id, CategoryDTO categoryDTO) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            Category category = existingCategory.get();
            category.setNome(categoryDTO.getNome());
            return categoryRepository.save(category);
        }
        return null;
    }
    
    public boolean deleteCategory(@NonNull String id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public Optional<Category> getCategoryById(@NonNull String id) {
        return categoryRepository.findById(id);
    }
}
