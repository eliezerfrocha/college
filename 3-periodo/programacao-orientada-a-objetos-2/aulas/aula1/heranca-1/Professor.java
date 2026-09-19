package aula1.heranca;

import java.util.Date;

import aula1.heranca.pessoa.Pessoa;

public class Professor extends Pessoa {
    private double salario;
    private String disciplina;

    public Professor(String nome, String cpf, Date dataNascimento, double salario, String disciplina) {
        super(nome, cpf, dataNascimento);
        this.salario = salario;
        this.disciplina = disciplina;
    }

    //getters e setters
    public String getDisciplina() {
        return disciplina;
    }

    public double getSalario() {
        return salario;
    }    
}
