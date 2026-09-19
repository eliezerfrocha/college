package com.example.sys.aula7.repository;

import com.example.sys.aula7.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    // Custom query methods can be defined here if needed
    
}
