package br.edu.iftm.tspi.porm.sistema_jpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.edu.iftm.tspi.porm.sistema_jpa.mapper.ProdutoMapper;
import br.edu.iftm.tspi.porm.sistema_jpa.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

// import br.edu.iftm.tspi.porm.sistema_jpa.domain.Categoria;
import br.edu.iftm.tspi.porm.sistema_jpa.domain.Produto;
import br.edu.iftm.tspi.porm.sistema_jpa.dto.ProdutoDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoRepository repository;

    private final ProdutoMapper mapper;

    @Autowired
    public ProdutoController(ProdutoRepository repository, ProdutoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> listarTodos(@RequestParam(required = false) String nome) {
        if (nome == null) {
            List<Produto> produtos = repository.findAll();
            return ResponseEntity.ok(mapper.toDtoList(produtos));
        }

        List<Produto> produtos = repository.findByNomeContainingIgnoreCase(nome);
        if (produtos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.toDtoList(produtos));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProdutoDto> listarPorId(@PathVariable Integer id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Produto com id " + id + " não encontrado"));

        return ResponseEntity.ok(mapper.toDto(produto));
    }

    @PostMapping
    public ResponseEntity<ProdutoDto> criar(@Valid @RequestBody ProdutoDto produtoDto) {
        Produto produto = mapper.toEntity(produtoDto);

        // Buscar a categoria pelo ID
        // Categoria categoria = repository.findById(produtoDto.getCategoriaId())
        //         .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não encontrada"));

        // produto.setCategoria(categoria);

        Produto produtoSalvo = repository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(produtoSalvo));
    }

    @PutMapping("{id}")
    public ResponseEntity<ProdutoDto> atualizar(@PathVariable Integer id, @Valid @RequestBody ProdutoDto produtoDto) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Produto com id " + id + " não encontrado");
        }

        produtoDto.setId(id);
        Produto produtoAtualizado = repository.save(mapper.toEntity(produtoDto));

        return ResponseEntity.ok(mapper.toDto(produtoAtualizado));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        return repository.findById(id)
                .map(produto -> {
                    repository.delete(produto);
                    return ResponseEntity.noContent().build();
                })
                .orElseThrow(() -> new EntityNotFoundException("Produto com id " + id + " não encontrado"));
    }
}
