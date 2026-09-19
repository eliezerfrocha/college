package com.example.sys.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sys.school.domain.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    // Custom query methods can be defined here if needed
    // For example, to find a Disciplina by name:
    // Optional<Disciplina> findByNOM_DISCIPLINA(String nome);   
}
