// src/main/java/com/exemplo/livros/LivroRepository.java
package com.cadastrolivros.cadastrolivros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastrolivros.cadastrolivros.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> { }