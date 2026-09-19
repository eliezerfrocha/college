package com.locadora.locadora_carros.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// @Table(name = "carros")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String modelo;
    
    @Column(nullable = false)
    private String marca;
    
    @Column(nullable = false)
    private int ano;

    @Column(nullable = false)
    private String placa;
}
