package com.augusto.apicursosalunos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {
    private String ra;
    private String nome;
    private String email;
    private String cursoSigla;
}
