package com.example.sys.aula7.controller.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.sys.aula7.domain.ErroDTO;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroDTO> tratarNaoEncontrado(EntityNotFoundException ex) {
        ErroDTO erro = new ErroDTO(null, null);
        erro.setMensagem(ex.getMessage());
        erro.setDataHora(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
