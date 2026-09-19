package com.sistemafilmes.sistema_filmes.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private Integer temporadas;
    private Integer episodios;
    private Integer anoEstreia;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serie", orphanRemoval = true)
    private List<Episodio> episodiosLista;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Integer temporadas) {
        this.temporadas = temporadas;
    }

    public Integer getEpisodios() {
        return episodios;
    }

    public void setEpisodios(Integer episodios) {
        this.episodios = episodios;
    }

    public Integer getAnoEstreia() {
        return anoEstreia;
    }

    public void setAnoEstreia(Integer anoEstreia) {
        this.anoEstreia = anoEstreia;
    }

    public List<Episodio> getEpisodiosLista() {
        return episodiosLista;
    }

    public void setEpisodiosLista(List<Episodio> episodiosLista) {
        this.episodiosLista = episodiosLista;
    }
}
