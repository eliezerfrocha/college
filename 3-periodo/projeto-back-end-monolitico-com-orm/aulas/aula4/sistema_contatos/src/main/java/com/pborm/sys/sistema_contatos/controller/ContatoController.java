package com.pborm.sys.sistema_contatos.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pborm.sys.sistema_contatos.domain.Contato;
import com.pborm.sys.sistema_contatos.domain.ErroDTO;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/contatos")
public class ContatoController {
    private List<Contato> contatos = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Contato>> listarContatos() {
        return ResponseEntity.ok(contatos);
    }

    @PostMapping
    public ResponseEntity<?> adicionarContato(@RequestBody Contato contato) {
        boolean contatoExiste = contatos.stream().anyMatch(nullContato -> nullContato.getCodigo().equals(contato.getCodigo()));     
        if (contatoExiste) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ErroDTO("Código já existe", contato.getCodigo(), null));
        }


        if (contato.getNome() == null || contato.getNome().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ErroDTO("Não recebi o nome", null, LocalDateTime.now()));
        }
        if (contato.getTelefone() == null || contato.getTelefone().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ErroDTO("Não recebi o telefone", null, LocalDateTime.now()));
        }
        if (contato.getEmail() == null || contato.getEmail().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ErroDTO("Não recebi o email", null, LocalDateTime.now()));
        }

        contatos.add(contato);
        return ResponseEntity.status(HttpStatus.CREATED).body(
            new ErroDTO("Contato adicionado com sucesso!", contato.getCodigo(), LocalDateTime.now()));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> putMethodName(@PathVariable String id, 
                                @RequestBody Contato contato) {
        for (Contato c : contatos) {
            if (c.getCodigo().equals(Integer.valueOf(id))) {
                c.setNome(contato.getNome());
                c.setTelefone(contato.getTelefone());
                c.setEmail(contato.getEmail());

                return ResponseEntity.status(HttpStatus.OK).body("Contato atualizado com sucesso!");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            new ErroDTO("Contato não encontrado!", null, LocalDateTime.now()
        ));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarContato(@PathVariable Integer id) {
        Contato contatoParaRemover = null;
        for (Contato contato : contatos) {
            if (contato.getCodigo().equals(id)) {
                contatoParaRemover = contato;
                break;
            }
        }

        if (contatoParaRemover != null) {
            contatos.remove(contatoParaRemover);
            return ResponseEntity.ok("Contato removido com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ErroDTO("Contato não encontrado", id, LocalDateTime.now()));
        }
    }
}
