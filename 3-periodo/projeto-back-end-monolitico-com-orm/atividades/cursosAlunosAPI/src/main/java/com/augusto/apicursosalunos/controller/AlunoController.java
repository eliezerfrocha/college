package com.augusto.apicursosalunos.controller;

import com.augusto.apicursosalunos.domain.Aluno;
import com.augusto.apicursosalunos.domain.Curso;
import com.augusto.apicursosalunos.dto.AlunoDTO;
import com.augusto.apicursosalunos.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final List<Aluno> alunos = new ArrayList<>();
    private final List<Curso> cursos = new ArrayList<>();

    @PostMapping
    public ResponseEntity<AlunoDTO> criarAluno(@RequestBody AlunoDTO alunoDTO) {
        if (alunos.stream().anyMatch(a -> a.getRa().equals(alunoDTO.getRa()))) {
            throw new ApiException(
                    "Já existe um aluno com o RA " + alunoDTO.getRa(),
                    HttpStatus.CONFLICT.value()
            );
        }

        boolean cursoExiste = cursos.stream()
                .anyMatch(c -> c.getSigla().equals(alunoDTO.getCursoSigla()));

        if (!cursoExiste) {
            throw new ApiException(
                    "O curso com sigla " + alunoDTO.getCursoSigla() + " não existe",
                    HttpStatus.BAD_REQUEST.value()
            );
        }

        Aluno novoAluno = new Aluno(
                alunoDTO.getRa(),
                alunoDTO.getNome(),
                alunoDTO.getEmail(),
                alunoDTO.getCursoSigla()
        );

        alunos.add(novoAluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoDTO);
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> listarAlunos() {
        List<AlunoDTO> alunosDTO = alunos.stream()
                .map(a -> new AlunoDTO(a.getRa(), a.getNome(), a.getEmail(), a.getCursoSigla()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(alunosDTO);
    }

    @GetMapping("/{ra}")
    public ResponseEntity<AlunoDTO> buscarAlunoPorRa(@PathVariable String ra) {
        Aluno aluno = alunos.stream()
                .filter(a -> a.getRa().equals(ra))
                .findFirst()
                .orElseThrow(() -> new ApiException(
                        "Aluno com RA " + ra + " não encontrado",
                        HttpStatus.NOT_FOUND.value()
                ));

        return ResponseEntity.ok(new AlunoDTO(aluno.getRa(), aluno.getNome(),
                aluno.getEmail(), aluno.getCursoSigla()));
    }

    @PutMapping("/{ra}")
    public ResponseEntity<AlunoDTO> atualizarAluno(@PathVariable String ra, @RequestBody AlunoDTO alunoDTO) {
        boolean cursoExiste = cursos.stream()
                .anyMatch(c -> c.getSigla().equals(alunoDTO.getCursoSigla()));

        if (!cursoExiste) {
            throw new ApiException(
                    "O curso com sigla " + alunoDTO.getCursoSigla() + " não existe",
                    HttpStatus.BAD_REQUEST.value()
            );
        }

        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getRa().equals(ra)) {
                Aluno alunoAtualizado = new Aluno(
                        ra,
                        alunoDTO.getNome(),
                        alunoDTO.getEmail(),
                        alunoDTO.getCursoSigla()
                );

                alunos.set(i, alunoAtualizado);
                return ResponseEntity.ok(new AlunoDTO(alunoAtualizado.getRa(),
                        alunoAtualizado.getNome(), alunoAtualizado.getEmail(),
                        alunoAtualizado.getCursoSigla()));
            }
        }

        throw new ApiException(
                "Aluno com RA " + ra + " não encontrado para atualização",
                HttpStatus.NOT_FOUND.value()
        );
    }

    @DeleteMapping("/{ra}")
    public ResponseEntity<Void> removerAluno(@PathVariable String ra) {
        boolean removido = alunos.removeIf(a -> a.getRa().equals(ra));

        if (removido) {
            return ResponseEntity.noContent().build();
        }

        throw new ApiException(
                "Aluno com RA " + ra + " não encontrado para remoção",
                HttpStatus.NOT_FOUND.value()
        );
    }

    @GetMapping("/curso/{sigla}")
    public ResponseEntity<List<AlunoDTO>> listarAlunosPorCurso(@PathVariable String sigla) {
        boolean cursoExiste = cursos.stream()
                .anyMatch(c -> c.getSigla().equals(sigla));

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