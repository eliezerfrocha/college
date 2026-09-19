package model;

import interfaces.Pagavel;
import model.exceptions.SalarioInvalidoException;
import util.Util;

public class Funcionario extends Pessoa implements Pagavel {
    protected double salarioBase;

    public Funcionario(String nome, String cpf, double salarioBase) {
        super(nome, cpf);
        this.salarioBase = salarioBase;
    }

    @Override
    public double calcularSalario() throws SalarioInvalidoException {
        if (salarioBase < 0) {
            throw new SalarioInvalidoException("Salario não pode ser negativo.");
        }
        return salarioBase;
    }

    public double calcularSalario(double bonus) throws SalarioInvalidoException {
        if (bonus < 0) {
            throw new SalarioInvalidoException("Bonus não pode ser negativo.");
        }
        return salarioBase + bonus;
    }

    @Override
    public String mostrarDados() {
        return "Nome: " + Util.formatarNome(nome) + "\n" +
                "CPF: " + Util.formatarCPF(cpf) + "\n" +
                "Salario Base: " + Util.formatarMoeda(salarioBase) + "\n";
    }

    public String getNome() {
        return nome;
    }
}
