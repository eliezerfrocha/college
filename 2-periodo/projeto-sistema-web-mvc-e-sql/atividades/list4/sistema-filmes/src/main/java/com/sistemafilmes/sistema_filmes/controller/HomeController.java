package com.sistemafilmes.sistema_filmes.controller;

import com.sistemafilmes.sistema_filmes.repository.FilmeRepository;
import com.sistemafilmes.sistema_filmes.repository.SerieRepository;
import com.sistemafilmes.sistema_filmes.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private MusicaRepository musicaRepository;

    @GetMapping("/")
    public String home(Model model) {
        // Contar os itens cadastrados
        long totalFilmes = filmeRepository.count();
        long totalSeries = serieRepository.count();
        long totalMusicas = musicaRepository.count();

        // Adicionar ao modelo
        model.addAttribute("totalFilmes", totalFilmes);
        model.addAttribute("totalSeries", totalSeries);
        model.addAttribute("totalMusicas", totalMusicas);

        return "home";
    }
}