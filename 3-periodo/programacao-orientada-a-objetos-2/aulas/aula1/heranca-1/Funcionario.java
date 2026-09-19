package aula1.heranca;

import java.util.Date;

import aula1.heranca.pessoa.Pessoa;

public class Funcionario extends Pessoa {
    private double salario;
    private Date dataAdmissao;
    private String cargo;

    public Funcionario(String nome, String cpf, Date dataNascimento, double salario, Date dataAdmissao, String cargo) {
        super(nome, cpf, dataNascimento);
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
    }

    //getters e setters
    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }
    
}
