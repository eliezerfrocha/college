package com.cadastrolivros.cadastrolivros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cadastrolivros.cadastrolivros.domain.Livro;
import com.cadastrolivros.cadastrolivros.repository.LivroRepository;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    // Método para listar livros (GET)
    @GetMapping
    public String listarLivros(Model model) {
        model.addAttribute("livros", livroRepository.findAll());
        return "livros/listar";
    }

    // Método para criar um novo livro (GET para o formulário)
    @GetMapping("/novo")
    public String novoLivroForm(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/formulario";
    }

    // Método para salvar um novo livro (POST)
    @PostMapping
    public String salvarLivro(@ModelAttribute Livro livro) {
        livroRepository.save(livro);
        return "redirect:/livros";
    }

    // Método para editar um livro existente (GET para carregar o formulário)
    @GetMapping("/{id}/editar")
    public String editarLivroForm(@PathVariable Long id, Model model) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado: ID " + id));
        model.addAttribute("livro", livro);
        return "livros/formulario";
    }

    // Método para deletar um livro existente
    // @DeleteMapping("/{id}")
    // public String deletarLivro(@PathVariable Long id, RedirectAttributes redirectAttributes) {
    //     Livro livro = livroRepository.findById(id)
    //             .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado: ID " + id));
    //     livroRepository.delete(livro);
    //     redirectAttributes.addFlashAttribute("mensagem", "Livro deletado com sucesso!");
    //     return "redirect:/livros"; // Redireciona para a lista de livros
    // }

    // Método para atualizar um livro existente (POST)
    @PostMapping("/{id}")
    public String atualizarLivro(@PathVariable Long id, @ModelAttribute Livro livroAtualizado) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado: ID " + id));
        livro.setTitulo(livroAtualizado.getTitulo());
        livro.setAutor(livroAtualizado.getAutor());
        livro.setAno(livroAtualizado.getAno());
        livroRepository.save(livro);
        return "redirect:/livros";
    }
}