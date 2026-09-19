package com.locadora.locadora_carros.controller;

import com.locadora.locadora_carros.domain.Carro;
import com.locadora.locadora_carros.service.CarroService;

import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carros")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public String listarCarros(Model model) {
        model.addAttribute("carros", carroService.listarTodos());
        return "carros/list";
    }

    @GetMapping("/novo")
    public String novoCarro(Model model) {
        model.addAttribute("carro", new Carro());
        return "carros/edit";
    }

    @GetMapping("/editar/{id}")
    public String editarCarro(@PathVariable Long id, Model model) {
        model.addAttribute("carro", carroService.buscarPorId(id).orElseThrow());
        return "carros/edit";
    }

    @PostMapping
    public String salvarCarro(@ModelAttribute Carro carro) {
        carroService.salvar(carro);
        return "redirect:/carros";
    }

    @DeleteMapping("/{id}")
    public String deletarCarro(@PathVariable Long id) {
        carroService.deletar(id);
        return "redirect:/carros";
    }
}
