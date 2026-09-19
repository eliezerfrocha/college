package com.lista.exercicios.atividades.model;

import lombok.*;

@Data
@AllArgsConstructor
public class MatematicaDTO {
    private String resultado;

    public MatematicaDTO(Number valor) {
        this.resultado = String.valueOf(valor);
    }
}
