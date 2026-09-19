package com.augusto.apicursosalunos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Curso {
    private String sigla;
    private String nome;
    private String descricao;
}
