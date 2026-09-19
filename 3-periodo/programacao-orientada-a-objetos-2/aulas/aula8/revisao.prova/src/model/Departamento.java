package model;

import model.exceptions.SalarioInvalidoException;

public class Departamento {
    private String nome;
    private Funcionario[] funcionarios;

    public Departamento(String nome, int tamanho) {
        this.nome = nome;
        this.funcionarios = new Funcionario[tamanho];
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Funcionario[] getFuncionarios() {
        return funcionarios;
    }
    public void setFuncionarios(Funcionario[] funcionarios) {
        this.funcionarios = funcionarios;
    }
    public void adicionarFuncionario(Funcionario funcionario) {
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] == null) {
                funcionarios[i] = funcionario;
                return;
            }
        }
        System.out.println("Departamento cheio, não é possível adicionar mais funcionários.");
    }
    public String listarFuncionarios() {
        StringBuilder sb = new StringBuilder();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario != null) {
                sb.append(funcionario.mostrarDados()).append("\n");
            }
        }
        return sb.toString();
    }
    public double calcularSalarioTotal() {
        double total = 0;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario != null) {
                try {
                    total += funcionario.calcularSalario();
                } catch (SalarioInvalidoException e) {
                    System.out.println("Erro ao calcular salário de " + funcionario.getNome() + ": " + e.getMessage());
                }
            }
        }
        return total;
    }

}
