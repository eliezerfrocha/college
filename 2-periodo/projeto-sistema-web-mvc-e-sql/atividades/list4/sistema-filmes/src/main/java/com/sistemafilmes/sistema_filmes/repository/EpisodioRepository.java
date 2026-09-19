package com.sistemafilmes.sistema_filmes.repository;

import com.sistemafilmes.sistema_filmes.domain.Episodio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodioRepository extends JpaRepository<Episodio, Long> {
    List<Episodio> findBySerieId(Long serieId);
}
