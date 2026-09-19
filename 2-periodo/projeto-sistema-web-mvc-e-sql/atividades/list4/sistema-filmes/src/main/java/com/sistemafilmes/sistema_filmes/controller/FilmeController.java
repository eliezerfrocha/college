package com.sistemafilmes.sistema_filmes.controller;

import com.sistemafilmes.sistema_filmes.domain.Filme;
import com.sistemafilmes.sistema_filmes.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public String listarFilmes(Model model) {
        model.addAttribute("filmes", filmeRepository.findAll());
        return "filmes/listar";
    }

    @GetMapping("/novo")
    public String novoFilmeForm(Model model) {
        model.addAttribute("filme", new Filme());
        return "filmes/formulario";
    }

    @PostMapping("/salvar")
    public String salvarFilme(@ModelAttribute Filme filme) {
        filmeRepository.save(filme);
        return "redirect:/filmes";
    }

    @GetMapping("/editar/{id}")
    public String editarFilme(@PathVariable Long id, Model model) {
        Filme filme = filmeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        model.addAttribute("filme", filme);
        return "filmes/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluirFilme(@PathVariable Long id) {
        filmeRepository.deleteById(id);
        return "redirect:/filmes";
    }
}
