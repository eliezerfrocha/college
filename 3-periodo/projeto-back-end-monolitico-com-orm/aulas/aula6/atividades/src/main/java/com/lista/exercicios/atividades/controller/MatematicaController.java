package com.lista.exercicios.atividades.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lista.exercicios.atividades.api.ErrorDTO;
import com.lista.exercicios.atividades.model.MatematicaDTO;
import com.lista.exercicios.atividades.model.ValoresDTO;

@RestController
@RequestMapping("/matematica")
public class MatematicaController {
    @RequestMapping("/soma")
    public ResponseEntity<?> soma(Integer a, Integer b) {
        if (a < 0 || b < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDTO("400", "Números inválidos!"));
        }
        if (a > 1000 || b > 1000) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDTO("400", "Números inválidos!"));
        }
        if (a == 0 && b == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDTO("400", "Números inválidos!"));
        }
        if (a == 0 || b == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDTO("400", "Números inválidos!"));
        }
        if (a == null || b == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDTO("400", "Números inválidos!"));
        }
        int soma = a + b;
        return ResponseEntity.ok(new MatematicaDTO(soma));
    }

    @RequestMapping("/fatorial")
    public ResponseEntity<?> fatorial(Integer n) {
        if (n < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDTO("400", "Número inválido!"));
        }
        if (n > 1000) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDTO("400", "Número inválido!"));
        }
        if (n == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDTO("400", "Número inválido!"));
        }
        int fatorial = 1;
        for (int i = 1; i <= n; i++) {
            fatorial *= i;
        }
        return ResponseEntity.ok(new MatematicaDTO(fatorial));
    }

    // @RequestMapping("/media")
    // public ResponseEntity<?> media(@RequestBody ValoresDTO valoresDTO) {
    //     List<Integer> valores = valoresDTO.getValores();

    //     if (valores == null || valores.size() < 2) {
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    //                 .body(new ErrorDTO("400", "Informe ao menos dois valores."));
    //     }

    //     Integer a = valores.get(0);
    //     Integer b = valores.get(1);

    //     if (a == null || b == null || a <= 0 || b <= 0 || a > 1000 || b > 1000) {
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    //                 .body(new ErrorDTO("400", "Números inválidos!"));
    //     }

    //     double media = (double) (a + b) / 2;
    //     return ResponseEntity.ok(new MatematicaDTO(media));
    // }

    // @RequestMapping("/soma-linhas")
    // public ResponseEntity<?> soma(ValoresDTO<Integer> valoresDTO) {
    //     if (a < 0 || b < 0) {
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    //                 .body(new ErrorDTO("400", "Números inválidos!"));
    //     }
    //     if (a > 1000 || b > 1000) {
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    //                 .body(new ErrorDTO("400", "Números inválidos!"));
    //     }
    //     if (a == 0 && b == 0) {
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    //                 .body(new ErrorDTO("400", "Números inválidos!"));
    //     }
    //     if (a == 0 || b == 0) {
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    //                 .body(new ErrorDTO("400", "Números inválidos!"));
    //     }
    //     if (a == null || b == null) {
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    //                 .body(new ErrorDTO("400", "Números inválidos!"));
    //     }
    //     int soma = a + b;
    //     return ResponseEntity.ok(new MatematicaDTO(soma));
    // }

}
