package com.system.pmvc.sistema_cliente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.system.pmvc.sistema_cliente.domain.Cliente;
import com.system.pmvc.sistema_cliente.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {
    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/clientes")
    public String getClientes(Model model) {
        model.addAttribute("clientes", clienteRepository.getClientes());
        return "clientesView";
    }   

    @GetMapping("/add")
    public String add(Model model, @ModelAttribute Cliente cliente) {
        clienteRepository.addCliente(cliente);
        return getClientes(model);
    }
}