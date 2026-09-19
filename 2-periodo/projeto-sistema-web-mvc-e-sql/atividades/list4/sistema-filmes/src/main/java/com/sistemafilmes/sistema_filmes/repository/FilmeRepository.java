package com.sistemafilmes.sistema_filmes.repository;

import com.sistemafilmes.sistema_filmes.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
}