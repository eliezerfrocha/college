package model;

public class Funcionario {
    private String nome;
    private String cargo;

    public Funcionario(String nome, String cargo) {
        this.nome = nome.trim();
        this.cargo = cargo.trim();
        validar();
    }

    private void validar() {
        if (this.nome.isEmpty() || this.cargo.isEmpty()) {
            throw new IllegalArgumentException("Nome e cargo não podem ser vazios.");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }
}