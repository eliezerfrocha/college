package com.example.sys.school.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sys.school.domain.Aluno;
import com.example.sys.school.repository.AlunoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private AlunoRepository repository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.repository = alunoRepository;
    }

    @GetMapping
    public List<Aluno> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public Aluno insert(@RequestBody Aluno aluno) {
        return repository.save(aluno);
    }
}
