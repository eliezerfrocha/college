package com.lista.exercicios.atividades.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO {
    private String codigo;
    private String message;
}
