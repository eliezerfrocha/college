package com.augusto.apicursosalunos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    private String ra;
    private String nome;
    private String email;
    private String cursoSigla;
}
