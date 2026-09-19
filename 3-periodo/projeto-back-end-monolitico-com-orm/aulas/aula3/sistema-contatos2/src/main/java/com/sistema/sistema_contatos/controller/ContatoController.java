package com.sistema.sistema_contatos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.sistema_contatos.domain.Contato;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class ContatoController {
    @GetMapping("/contatos")
    public ResponseEntity<List<Contato>> getContatos() {
        // retorna uma lista de contatos vindas do metodo mockContatos()
        return ResponseEntity.ok().body(mockContatos());
    }

    @GetMapping("contatos/{id}")
    public ResponseEntity<Contato> getContatoById(@PathVariable Integer id) {
        for (Contato contato : mockContatos()) {
            if (Objects.equals(contato.getId(), id)) { 
                return ResponseEntity.ok(contato);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("{nome}")
    public ResponseEntity<Contato> getContatoByNome(@RequestParam String nome) {
        for (Contato contato : mockContatos()) {
            if (Objects.equals(contato.getNome(), nome)) {
                return ResponseEntity.ok(contato);
            }
        }

        return ResponseEntity.notFound().build();
    }
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    

    public List<Contato> mockContatos() {
        List<Contato> contatos = new ArrayList<>();

        contatos.add(new Contato(1, "Goku"));
        contatos.add(new Contato(2, "Vegeta"));
        contatos.add(new Contato(3, "Gohan"));
        contatos.add(new Contato(4, "Piccolo"));
        contatos.add(new Contato(5, "Kuririn"));
        contatos.add(new Contato(6, "Yamcha"));
        contatos.add(new Contato(7, "Tenshinhan"));
        contatos.add(new Contato(8, "Chaoz"));
        contatos.add(new Contato(9, "Mestre Kame"));
        contatos.add(new Contato(10, "Bulma"));

        return contatos;
    }
}
