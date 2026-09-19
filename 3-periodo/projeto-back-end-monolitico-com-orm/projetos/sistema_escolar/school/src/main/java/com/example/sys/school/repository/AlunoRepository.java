package com.example.sys.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sys.school.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // Custom query methods can be defined here if needed
    // For example, to find an Aluno by email:
    // Optional<Aluno> findByEmail(String email);
}
