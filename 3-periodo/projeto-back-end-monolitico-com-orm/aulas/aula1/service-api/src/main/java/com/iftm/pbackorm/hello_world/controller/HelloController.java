package com.iftm.pbackorm.hello_world.controller;

import java.util.Arrays;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.pbackorm.hello_world.domain.HelloResponse;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class HelloController {

    @GetMapping("/hello")
    public HelloResponse hello() {
        // Obtém a data e hora atual formatada
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        // Retorna um objeto JSON com os dados
        return new HelloResponse(agora.format(formatter), "Hello, world!");
    }

    @GetMapping("/contato") 
    public List<Contato> getContatos() {
        return Arrays.asList(
            new Contato(1, "João"),
            new Contato(2, "Maria"),
            new Contato(3, "José"),
            new Contato(4, "Ana")
        );
    }
}
