package com.lista.exercicios.atividades.model;

import java.util.List;

public class SomaLinhasDTO {
    private List<Integer> somas;

    public SomaLinhasDTO(List<Integer> somas) {
        this.somas = somas;
    }

    public List<Integer> getSomas() {
        return somas;
    }

    public void setSomas(List<Integer> somas) {
        this.somas = somas;
    }
}
