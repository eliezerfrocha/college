package com.locadora.locadora_carros.controller;

import com.locadora.locadora_carros.domain.Cliente; 
import com.locadora.locadora_carros.service.ClienteService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        return "clientes/list";
    }

    @GetMapping("/novo")
    public String novoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/edit";
    }

    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable Long id, Model model) {
        model.addAttribute("cliente", clienteService.buscarPorId(id).orElseThrow());
        return "clientes/edit";
    }

    @PostMapping
    public String salvarCliente(@ModelAttribute Cliente cliente) {
        clienteService.salvar(cliente);
        return "redirect:/clientes";
    }

    @PutMapping("/editar/{id}")
    public String atualizarCliente(@PathVariable Long id, @ModelAttribute Cliente cliente) {
        cliente.setId(id); // Garante que o ID seja mantido
        clienteService.salvar(cliente);
        return "redirect:/clientes";
    }

    @DeleteMapping("/{id}")
    public String deletarCliente(@PathVariable Long id) {
        clienteService.deletar(id);
        return "redirect:/clientes";
    }
}
