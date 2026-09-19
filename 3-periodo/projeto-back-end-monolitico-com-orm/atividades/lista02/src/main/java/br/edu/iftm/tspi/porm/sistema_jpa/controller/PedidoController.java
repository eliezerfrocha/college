package br.edu.iftm.tspi.porm.sistema_jpa.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.tspi.porm.sistema_jpa.domain.Cliente;
import br.edu.iftm.tspi.porm.sistema_jpa.domain.DetalhePedido;
import br.edu.iftm.tspi.porm.sistema_jpa.domain.DetalhePedidoId;
import br.edu.iftm.tspi.porm.sistema_jpa.domain.Pedido;
import br.edu.iftm.tspi.porm.sistema_jpa.domain.Produto;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.DetalhePedidoDto;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.PedidoDto;
import br.edu.iftm.tspi.porm.sistema_jpa.mapper.DetalhePedidoMapper;
import br.edu.iftm.tspi.porm.sistema_jpa.mapper.PedidoMapper;
import br.edu.iftm.tspi.porm.sistema_jpa.repository.ClienteRepository;
import br.edu.iftm.tspi.porm.sistema_jpa.repository.DetalhePedidoRepository;
import br.edu.iftm.tspi.porm.sistema_jpa.repository.PedidoRepository;
import br.edu.iftm.tspi.porm.sistema_jpa.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final DetalhePedidoRepository detalhePedidoRepository;
    private final PedidoMapper pedidoMapper;
    private final DetalhePedidoMapper detalhePedidoMapper;

    public PedidoController(PedidoRepository pedidoRepository,
                          ClienteRepository clienteRepository,
                          ProdutoRepository produtoRepository,
                          DetalhePedidoRepository detalhePedidoRepository,
                          PedidoMapper pedidoMapper,
                          DetalhePedidoMapper detalhePedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.detalhePedidoRepository = detalhePedidoRepository;
        this.pedidoMapper = pedidoMapper;
        this.detalhePedidoMapper = detalhePedidoMapper;
    }

    @GetMapping
    public ResponseEntity<List<PedidoDto>> listarTodos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        List<PedidoDto> pedidosDto = pedidoMapper.toDtoList(pedidos);
        return ResponseEntity.ok(pedidosDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> buscarPorId(@PathVariable Integer id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                    "Pedido com ID " + id + " não encontrado"));
        
        PedidoDto pedidoDto = pedidoMapper.toDto(pedido);
        return ResponseEntity.ok(pedidoDto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PedidoDto> criar(@Valid @RequestBody PedidoDto pedidoDto) {
        Cliente cliente = clienteRepository.findById(pedidoDto.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException(
                    "Cliente com ID " + pedidoDto.getClienteId() + " não encontrado"));

        validarItensPedido(pedidoDto.getDetalhesPedido());

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(new Date());

        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        List<DetalhePedido> detalhesPedido = criarDetalhesPedido(
            pedidoSalvo, pedidoDto.getDetalhesPedido());
        pedidoSalvo.setDetalhesPedido(detalhesPedido);

        PedidoDto pedidoSalvoDto = pedidoMapper.toDto(pedidoSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvoDto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoDto> atualizar(@PathVariable Integer id, 
                                             @Valid @RequestBody PedidoDto pedidoDto) {
        Pedido pedidoExistente = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                    "Pedido com ID " + id + " não encontrado"));

        Cliente cliente = clienteRepository.findById(pedidoDto.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException(
                    "Cliente com ID " + pedidoDto.getClienteId() + " não encontrado"));

        validarItensPedido(pedidoDto.getDetalhesPedido());

        pedidoExistente.setCliente(cliente);
        pedidoExistente.setDataPedido(pedidoDto.getDataPedido());

        detalhePedidoRepository.deleteByIdPedidoId(id);

        List<DetalhePedido> novosDetalhes = criarDetalhesPedido(
            pedidoExistente, pedidoDto.getDetalhesPedido());
        pedidoExistente.setDetalhesPedido(novosDetalhes);

        Pedido pedidoAtualizado = pedidoRepository.save(pedidoExistente);
        PedidoDto pedidoAtualizadoDto = pedidoMapper.toDto(pedidoAtualizado);
        
        return ResponseEntity.ok(pedidoAtualizadoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                    "Pedido com ID " + id + " não encontrado"));

        pedidoRepository.delete(pedido);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{pedidoId}/items")
    public ResponseEntity<List<DetalhePedidoDto>> listarItens(@PathVariable Integer pedidoId) {
        if (!pedidoRepository.existsById(pedidoId)) {
            throw new EntityNotFoundException(
                "Pedido com ID " + pedidoId + " não encontrado");
        }

        List<DetalhePedido> detalhes = detalhePedidoRepository.findByIdPedidoId(pedidoId);
        List<DetalhePedidoDto> detalhesDto = detalhePedidoMapper.toDtoList(detalhes);
        return ResponseEntity.ok(detalhesDto);
    }

    @PostMapping("/{pedidoId}/items")
    @Transactional
    public ResponseEntity<DetalhePedidoDto> adicionarItem(@PathVariable Integer pedidoId,
                                                        @Valid @RequestBody DetalhePedidoDto itemDto) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new EntityNotFoundException(
                    "Pedido com ID " + pedidoId + " não encontrado"));

        Produto produto = produtoRepository.findById(itemDto.getProdutoId())
                .orElseThrow(() -> new EntityNotFoundException(
                    "Produto com ID " + itemDto.getProdutoId() + " não encontrado"));

        validarItemPedido(itemDto);

        DetalhePedido detalhePedido = new DetalhePedido();
        DetalhePedidoId id = new DetalhePedidoId();
        id.setPedidoId(pedidoId);
        id.setProdutoId(itemDto.getProdutoId());
        
        detalhePedido.setId(id);
        detalhePedido.setPedido(pedido);
        detalhePedido.setProduto(produto);
        detalhePedido.setPrecoVenda(itemDto.getPrecoVenda());
        detalhePedido.setQuantidade(itemDto.getQuantidade());
        detalhePedido.setDesconto(itemDto.getDesconto() != null ? itemDto.getDesconto() : 0.0);

        DetalhePedido detalheSalvo = detalhePedidoRepository.save(detalhePedido);
        DetalhePedidoDto detalheSalvoDto = detalhePedidoMapper.toDto(detalheSalvo);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(detalheSalvoDto);
    }

    @PutMapping("/{pedidoId}/items/{produtoId}")
    @Transactional
    public ResponseEntity<DetalhePedidoDto> atualizarItem(@PathVariable Integer pedidoId,
                                                        @PathVariable Integer produtoId,
                                                        @Valid @RequestBody DetalhePedidoDto itemDto) {
        DetalhePedidoId id = new DetalhePedidoId();
        id.setPedidoId(pedidoId);
        id.setProdutoId(produtoId);
        
        DetalhePedido detalheExistente = detalhePedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                    "Item não encontrado no pedido " + pedidoId));

        validarItemPedido(itemDto);

        detalheExistente.setPrecoVenda(itemDto.getPrecoVenda());
        detalheExistente.setQuantidade(itemDto.getQuantidade());
        detalheExistente.setDesconto(itemDto.getDesconto() != null ? itemDto.getDesconto() : 0.0);

        DetalhePedido detalheAtualizado = detalhePedidoRepository.save(detalheExistente);
        DetalhePedidoDto detalheAtualizadoDto = detalhePedidoMapper.toDto(detalheAtualizado);
        
        return ResponseEntity.ok(detalheAtualizadoDto);
    }

    @DeleteMapping("/{pedidoId}/items/{produtoId}")
    public ResponseEntity<Void> removerItem(@PathVariable Integer pedidoId,
                                          @PathVariable Integer produtoId) {
        DetalhePedidoId id = new DetalhePedidoId();
        id.setPedidoId(pedidoId);
        id.setProdutoId(produtoId);
        
        DetalhePedido detalhe = detalhePedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                    "Item não encontrado no pedido " + pedidoId));

        detalhePedidoRepository.delete(detalhe);
        return ResponseEntity.noContent().build();
    }

    private void validarItensPedido(List<DetalhePedidoDto> itens) {
        if (itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("Pedido deve ter pelo menos um item");
        }

        for (DetalhePedidoDto item : itens) {
            validarItemPedido(item);
        }
    }

    private void validarItemPedido(DetalhePedidoDto item) {
        if (item.getPrecoVenda() == null || item.getPrecoVenda() <= 0) {
            throw new IllegalArgumentException("Preço de venda deve ser maior que zero");
        }
        
        if (item.getQuantidade() == null || item.getQuantidade() <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        
        if (item.getDesconto() != null && item.getDesconto() < 0) {
            throw new IllegalArgumentException("Desconto não pode ser negativo");
        }
    }

    private List<DetalhePedido> criarDetalhesPedido(Pedido pedido, List<DetalhePedidoDto> itensDto) {
        return itensDto.stream().map(itemDto -> {
            Produto produto = produtoRepository.findById(itemDto.getProdutoId())
                    .orElseThrow(() -> new EntityNotFoundException(
                        "Produto com ID " + itemDto.getProdutoId() + " não encontrado"));

            DetalhePedido detalhe = new DetalhePedido();
            DetalhePedidoId id = new DetalhePedidoId();
            id.setPedidoId(pedido.getId());
            id.setProdutoId(itemDto.getProdutoId());
            
            detalhe.setId(id);
            detalhe.setPedido(pedido);
            detalhe.setProduto(produto);
            detalhe.setPrecoVenda(itemDto.getPrecoVenda());
            detalhe.setQuantidade(itemDto.getQuantidade());
            detalhe.setDesconto(itemDto.getDesconto() != null ? itemDto.getDesconto() : 0.0);

            return detalhePedidoRepository.save(detalhe);
        }).toList();
    }
} 