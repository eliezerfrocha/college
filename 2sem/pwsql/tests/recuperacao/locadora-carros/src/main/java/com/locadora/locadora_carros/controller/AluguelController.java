package com.locadora.locadora_carros.controller;

import com.locadora.locadora_carros.domain.Aluguel;
import com.locadora.locadora_carros.service.AluguelService;
import com.locadora.locadora_carros.service.CarroService;
import com.locadora.locadora_carros.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/alugueis")
public class AluguelController {

    private final AluguelService aluguelService;
    private final CarroService carroService;
    private final ClienteService clienteService;

    public AluguelController(AluguelService aluguelService, CarroService carroService, ClienteService clienteService) {
        this.aluguelService = aluguelService;
        this.carroService = carroService;
        this.clienteService = clienteService;
    }

    // Listagem de aluguéis
    @GetMapping
    public String listarAlugueis(Model model) {
        model.addAttribute("alugueis", aluguelService.listarTodos());
        return "alugueis/list";
    }

    // Exibir formulário para novo aluguel
    @GetMapping("/novo")
    public String novoAluguel(Model model) {
        model.addAttribute("aluguel", new Aluguel());
        model.addAttribute("carros", carroService.listarTodos());
        model.addAttribute("clientes", clienteService.listarTodos());
        return "alugueis/edit";
    }

    // Exibir formulário de edição
    @GetMapping("/editar/{id}")
    public String editarAluguel(@PathVariable Long id, Model model) {
        Optional<Aluguel> aluguelOpt = aluguelService.buscarPorId(id);
        if (aluguelOpt.isPresent()) {
            model.addAttribute("aluguel", aluguelOpt.get());
            model.addAttribute("carros", carroService.listarTodos());
            model.addAttribute("clientes", clienteService.listarTodos());
            return "alugueis/edit";
        }
        return "redirect:/alugueis";
    }

    // Salvar ou atualizar aluguel
    @PostMapping("/salvar")
    public String salvarAluguel(@ModelAttribute Aluguel aluguel, @RequestParam Long carroId, @RequestParam Long clienteId) {
        aluguel.setCarro(carroService.buscarPorId(carroId).orElseThrow());
        aluguel.setCliente(clienteService.buscarPorId(clienteId).orElseThrow());
        aluguelService.salvar(aluguel);
        return "redirect:/alugueis";
    }

    // Deletar aluguel
    @PostMapping("/deletar/{id}")
    public String deletarAluguel(@PathVariable Long id) {
        aluguelService.deletar(id);
        return "redirect:/alugueis";
    }
}