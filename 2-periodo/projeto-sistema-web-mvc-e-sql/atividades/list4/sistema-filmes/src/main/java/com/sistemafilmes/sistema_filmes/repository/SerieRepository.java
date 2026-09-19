package com.sistemafilmes.sistema_filmes.repository;

import com.sistemafilmes.sistema_filmes.domain.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {
}
