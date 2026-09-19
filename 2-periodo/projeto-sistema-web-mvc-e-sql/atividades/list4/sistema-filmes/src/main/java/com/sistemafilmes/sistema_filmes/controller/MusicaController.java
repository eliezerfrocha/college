package com.sistemafilmes.sistema_filmes.controller;

import com.sistemafilmes.sistema_filmes.domain.Musica;
import com.sistemafilmes.sistema_filmes.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaRepository musicaRepository;

    @GetMapping
    public String listarMusicas(Model model) {
        model.addAttribute("musicas", musicaRepository.findAll());
        return "musicas/listar";
    }

    @GetMapping("/nova")
    public String novaMusicaForm(Model model) {
        model.addAttribute("musica", new Musica());
        return "musicas/formulario";
    }

    @PostMapping("/salvar")
    public String salvarMusica(@ModelAttribute Musica musica) {
        musicaRepository.save(musica);
        return "redirect:/musicas";
    }

    @GetMapping("/editar/{id}")
    public String editarMusica(@PathVariable Long id, Model model) {
        Musica musica = musicaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("musica", musica);
        return "musicas/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluirMusica(@PathVariable Long id) {
        musicaRepository.deleteById(id);
        return "redirect:/musicas";
    }
}
