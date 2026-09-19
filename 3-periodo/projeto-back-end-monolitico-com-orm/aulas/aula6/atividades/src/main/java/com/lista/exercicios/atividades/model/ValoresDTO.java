package com.lista.exercicios.atividades.model;

import java.util.List;

public class ValoresDTO<T extends Number> {
    private List<T> valores;

    public List<T> getValores() {
        return valores;
    }

    public void setValores(List<T> valores) {
        this.valores = valores;
    }
}