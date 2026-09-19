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
@RequestMapping("/episodios")
public class EpisodioController {

    @Autowired
    private EpisodioRepository episodioRepository;

    @Autowired
    private SerieRepository serieRepository;

    @GetMapping("/nova/{serieId}")
    public String novoEpisodioForm(@PathVariable Long serieId, Model model) {
        Episodio episodio = new Episodio();
        Serie serie = serieRepository.findById(serieId)
                .orElseThrow(() -> new IllegalArgumentException("ID da série inválido: " + serieId));
        episodio.setSerie(serie);
        model.addAttribute("episodio", episodio);
        return "episodios/formulario";
    }

    @PostMapping("/salvar")
    public String salvarEpisodio(@ModelAttribute Episodio episodio) {
        episodioRepository.save(episodio);
        return "redirect:/series/" + episodio.getSerie().getId() + "/episodios";
    }

    @GetMapping("/editar/{id}")
    public String editarEpisodio(@PathVariable Long id, Model model) {
        Episodio episodio = episodioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("episodio", episodio);
        return "episodios/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluirEpisodio(@PathVariable Long id) {
        Episodio episodio = episodioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        Long serieId = episodio.getSerie().getId();
        episodioRepository.deleteById(id);
        return "redirect:/series/" + serieId + "/episodios";
    }
}
