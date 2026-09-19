package com.example.sys.aula7.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sys.aula7.domain.Categoria;
import com.example.sys.aula7.repository.CategoriaRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listaTodos() {
        return ResponseEntity.ok(categoriaRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> listaPorId(@PathVariable Integer id) {
        Categoria categoria = categoriaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Categoria " + id + " não encontrada"));
        return ResponseEntity.ok(categoria);
    }
    
    
}
