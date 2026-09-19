package com.example.loja.system.controller;

import com.example.loja.system.model.Produto;
import com.example.loja.system.service.ProdutoService;
import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Produto adicionar(@Valid @RequestBody Produto produto) {
        return service.salvar(produto);
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
        Produto existente = service.buscarPorId(id);
        existente.setNome(produto.getNome());
        existente.setPreco(produto.getPreco());
        existente.setQuantidade(produto.getQuantidade());
        return service.salvar(existente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
