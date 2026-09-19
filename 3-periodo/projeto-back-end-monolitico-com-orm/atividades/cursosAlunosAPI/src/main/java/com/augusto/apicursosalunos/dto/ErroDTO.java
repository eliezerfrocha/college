package com.augusto.apicursosalunos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErroDTO {
    private int status;
    private String mensagem;
    private LocalDateTime timestamp;
}
