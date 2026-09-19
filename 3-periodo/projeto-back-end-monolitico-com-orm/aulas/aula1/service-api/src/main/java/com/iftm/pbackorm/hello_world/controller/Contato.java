package com.iftm.pbackorm.hello_world.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contato {
    private Integer codigo;
    private String nome;
}
