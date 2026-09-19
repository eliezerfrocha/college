package aula1.heranca;

import java.util.Date;

import aula1.heranca.pessoa.Pessoa;

public class Aluno extends Pessoa {
    private long matricula;

    public Aluno(String nome, String cpf, Date dataNascimento, long matricula) {
        super(nome, cpf, dataNascimento);
        this.matricula = matricula;
    }

    //getters e setters
    public long getMatricula() {
        return matricula;
    }
}
