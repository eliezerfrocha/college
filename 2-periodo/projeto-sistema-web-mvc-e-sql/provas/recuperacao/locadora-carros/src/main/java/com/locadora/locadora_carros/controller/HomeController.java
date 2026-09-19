package com.locadora.locadora_carros.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.locadora.locadora_carros.service.AluguelService;
import com.locadora.locadora_carros.service.CarroService;
import com.locadora.locadora_carros.service.ClienteService;

@Controller
public class HomeController {

    private final CarroService carroService;
    private final ClienteService clienteService;
    private final AluguelService aluguelService;

    public HomeController(CarroService carroService, ClienteService clienteService, AluguelService aluguelService) {
        this.carroService = carroService;
        this.clienteService = clienteService;
        this.aluguelService = aluguelService;
    }

    @GetMapping("/")
    public String home(Model model, RedirectAttributes redirectAttributes) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
            return "redirect:/login";
        }

        model.addAttribute("totalCarros", carroService.listarTodos().size());
        model.addAttribute("totalClientes", clienteService.listarTodos().size());
        model.addAttribute("totalAlugueis", aluguelService.listarTodos().size());
        return "index";
    }
}