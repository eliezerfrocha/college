package com.system.pmvc.sistema_cliente.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.system.pmvc.sistema_cliente.domain.Cliente;

@Component
public class ClienteRepository {
    private List<Cliente> clientes;

    public ClienteRepository(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public ClienteRepository() {
        clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Carlos", "Rua das Flores"));
        clientes.add(new Cliente(1, "Antonio", "Rua das Rosas"));
        clientes.add(new Cliente(1, "Francisco", "Rua das Pedras"));
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
}
