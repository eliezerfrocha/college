package com.sistemafilmes.sistema_filmes.repository;

import com.sistemafilmes.sistema_filmes.domain.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {
}
