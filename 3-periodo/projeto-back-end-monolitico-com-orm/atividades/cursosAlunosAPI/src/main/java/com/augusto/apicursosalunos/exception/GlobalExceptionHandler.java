package com.augusto.apicursosalunos.exception;

import com.augusto.apicursosalunos.dto.ErroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErroDTO> handleApiException(ApiException ex) {
        ErroDTO erro = new ErroDTO(
                ex.getStatus(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(ex.getStatus()).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroDTO> handleGenericException(Exception ex) {
        ErroDTO erro = new ErroDTO(
                500,
                "Erro interno do servidor: " + ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(500).body(erro);
    }
}