package com.example.loja.system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data // Gera getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @DecimalMin("0.01")
    private Double preco;

    @Min(0)
    private Integer quantidade;
}
