package com.pborm.sys.sistema_contatos.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroDTO {
    private String message;
    private Integer codigo;
    private LocalDateTime dLocalDateTime;
}
