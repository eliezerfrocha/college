package br.edu.iftm.tspi.porm.sistema_jpa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.tspi.porm.sistema_jpa.domain.Cliente;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.ClienteDto;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.PedidoDto;
import br.edu.iftm.tspi.porm.sistema_jpa.mapper.ClienteMapper;
import br.edu.iftm.tspi.porm.sistema_jpa.mapper.PedidoMapper;
import br.edu.iftm.tspi.porm.sistema_jpa.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final PedidoMapper pedidoMapper;

    public ClienteController(ClienteRepository clienteRepository, 
                           ClienteMapper clienteMapper,
                           PedidoMapper pedidoMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
        this.pedidoMapper = pedidoMapper;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> listarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDto> clientesDto = clienteMapper.toDtoList(clientes);
        return ResponseEntity.ok(clientesDto);
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteDto> buscarPorId(@PathVariable String clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException(
                    "Cliente com ID " + clienteId + " não encontrado"));
        
        ClienteDto clienteDto = clienteMapper.toDto(cliente);
        return ResponseEntity.ok(clienteDto);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> criar(@Valid @RequestBody ClienteDto clienteDto) {
        if (clienteDto.getId() != null && clienteRepository.existsById(clienteDto.getId())) {
            throw new IllegalArgumentException(
                "Cliente com ID " + clienteDto.getId() + " já existe");
        }

        Cliente cliente = clienteMapper.toEntity(clienteDto);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        ClienteDto clienteSalvoDto = clienteMapper.toDto(clienteSalvo);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvoDto);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<ClienteDto> atualizar(@PathVariable String clienteId, 
                                              @Valid @RequestBody ClienteDto clienteDto) {
        if (!clienteRepository.existsById(clienteId)) {
            throw new EntityNotFoundException(
                "Cliente com ID " + clienteId + " não encontrado");
        }

        clienteDto.setId(clienteId);
        Cliente cliente = clienteMapper.toEntity(clienteDto);
        Cliente clienteAtualizado = clienteRepository.save(cliente);
        ClienteDto clienteAtualizadoDto = clienteMapper.toDto(clienteAtualizado);
        
        return ResponseEntity.ok(clienteAtualizadoDto);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable String clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException(
                    "Cliente com ID " + clienteId + " não encontrado"));

        clienteRepository.delete(cliente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{clienteId}/pedidos")
    public ResponseEntity<List<PedidoDto>> listarPedidos(@PathVariable String clienteId) {
        Cliente cliente = clienteRepository.findByIdWithPedidos(clienteId);
        if (cliente == null) {
            throw new EntityNotFoundException(
                "Cliente com ID " + clienteId + " não encontrado");
        }

        List<PedidoDto> pedidosDto = pedidoMapper.toDtoList(cliente.getPedidos());
        return ResponseEntity.ok(pedidosDto);
    }
} 