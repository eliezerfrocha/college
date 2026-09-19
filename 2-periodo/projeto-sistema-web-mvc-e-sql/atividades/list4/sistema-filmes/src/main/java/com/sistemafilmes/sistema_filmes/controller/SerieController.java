package com.sistemafilmes.sistema_filmes.controller;

import com.sistemafilmes.sistema_filmes.domain.Episodio;
import com.sistemafilmes.sistema_filmes.domain.Serie;
import com.sistemafilmes.sistema_filmes.repository.EpisodioRepository;
import com.sistemafilmes.sistema_filmes.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private EpisodioRepository episodioRepository;

    @GetMapping
    public String listarSeries(Model model) {
        model.addAttribute("series", serieRepository.findAll());
        return "series/listar";
    }

    @GetMapping("/nova")
    public String novaSerieForm(Model model) {
        model.addAttribute("serie", new Serie());
        return "series/formulario";
    }

    @PostMapping("/salvar")
    public String salvarSerie(@ModelAttribute Serie serie) {
        serieRepository.save(serie);
        return "redirect:/series";
    }

    @GetMapping("/editar/{id}")
    public String editarSerie(@PathVariable Long id, Model model) {
        Serie serie = serieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("serie", serie);
        return "series/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluirSerie(@PathVariable Long id) {
        serieRepository.deleteById(id);
        return "redirect:/series";
    }

    @GetMapping("/{id}/episodios")
    public String gerenciarEpisodios(@PathVariable Long id, Model model) {
        Serie serie = serieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("serie", serie);
        model.addAttribute("episodios", episodioRepository.findBySerieId(id));
        return "episodios/listar";
    }
}
