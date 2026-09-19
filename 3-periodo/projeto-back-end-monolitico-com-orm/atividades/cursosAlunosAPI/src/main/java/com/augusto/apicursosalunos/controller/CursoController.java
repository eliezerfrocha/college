package com.augusto.apicursosalunos.controller;

import com.augusto.apicursosalunos.domain.Aluno;
import com.augusto.apicursosalunos.domain.Curso;
import com.augusto.apicursosalunos.dto.AlunoDTO;
import com.augusto.apicursosalunos.dto.CursoDTO;
import com.augusto.apicursosalunos.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final List<Curso> cursos = new ArrayList<>();
    private final List<Aluno> alunos = new ArrayList<>();

    @PostMapping
    public ResponseEntity<CursoDTO> criarCurso(@RequestBody CursoDTO cursoDTO) {
        if (cursos.stream().anyMatch(c -> c.getSigla().equals(cursoDTO.getSigla()))) {
            throw new ApiException(
                    "Já existe um curso com a sigla " + cursoDTO.getSigla(),
                    HttpStatus.CONFLICT.value()
            );
        }

        Curso novoCurso = new Curso(
                cursoDTO.getSigla(),
                cursoDTO.getNome(),
                cursoDTO.getDescricao()
        );

        cursos.add(novoCurso);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoDTO);
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> listarCursos() {
        List<CursoDTO> cursosDTO = cursos.stream()
                .map(c -> new CursoDTO(c.getSigla(), c.getNome(), c.getDescricao()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(cursosDTO);
    }

    @GetMapping("/{sigla}")
    public ResponseEntity<CursoDTO> buscarCursoPorSigla(@PathVariable String sigla) {
        Curso curso = cursos.stream()
                .filter(c -> c.getSigla().equals(sigla))
                .findFirst()
                .orElseThrow(() -> new ApiException(
                        "Curso com sigla " + sigla + " não encontrado",
                        HttpStatus.NOT_FOUND.value()
                ));

        return ResponseEntity.ok(new CursoDTO(curso.getSigla(), curso.getNome(), curso.getDescricao()));
    }

    @PutMapping("/{sigla}")
    public ResponseEntity<CursoDTO> atualizarCurso(@PathVariable String sigla, @RequestBody CursoDTO cursoDTO) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getSigla().equals(sigla)) {
                Curso cursoAtualizado = new Curso(
                        sigla,
                        cursoDTO.getNome(),
                        cursoDTO.getDescricao()
                );

                cursos.set(i, cursoAtualizado);
                return ResponseEntity.ok(new CursoDTO(cursoAtualizado.getSigla(),
                        cursoAtualizado.getNome(), cursoAtualizado.getDescricao()));
            }
        }

        throw new ApiException(
                "Curso com sigla " + sigla + " não encontrado para atualização",
                HttpStatus.NOT_FOUND.value()
        );
    }

    @DeleteMapping("/{sigla}")
    public ResponseEntity<Void> removerCurso(@PathVariable String sigla) {
        boolean removido = cursos.removeIf(c -> c.getSigla().equals(sigla));

        if (removido) {
            alunos.removeIf(a -> a.getCursoSigla().equals(sigla));
            return ResponseEntity.noContent().build();
        }

        throw new ApiException(
                "Curso com sigla " + sigla + " não encontrado para remoção",
                HttpStatus.NOT_FOUND.value()
        );
    }

    @GetMapping("/{sigla}/alunos")
    public ResponseEntity<List<AlunoDTO>> listarAlunosDoCurso(@PathVariable String sigla) {
        boolean cursoExiste = cursos.stream().anyMatch(c -> c.getSigla().equals(sigla));

        if (!cursoExiste) {
            throw new ApiException(
                    "Curso com sigla " + sigla + " não encontrado",
                    HttpStatus.NOT_FOUND.value()
            );
        }

        List<AlunoDTO> alunosDTO = alunos.stream()
                .filter(a -> a.getCursoSigla().equals(sigla))
                .map(a -> new AlunoDTO(a.getRa(), a.getNome(), a.getEmail(), a.getCursoSigla()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(alunosDTO);
    }
}