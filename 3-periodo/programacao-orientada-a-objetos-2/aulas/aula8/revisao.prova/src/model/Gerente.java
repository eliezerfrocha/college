package model;

import model.exceptions.SalarioInvalidoException;
import util.Util;

public class Gerente extends Funcionario {
    private double bonus;

    public Gerente(String nome, String cpf, double salarioBase, double bonus) throws SalarioInvalidoException {
        super(nome, cpf, salarioBase);
        this.bonus = validarBonus(bonus);
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public double calcularSalario() throws SalarioInvalidoException {
        return super.calcularSalario() + bonus;
    }

    @Override
    public String mostrarDados() {
        return super.mostrarDados() +
                "Cargo: Gerente\n" +
                "Bonus: " + Util.formatarMoeda(bonus) + "\n";
    }

    public double validarBonus(double bonus) throws SalarioInvalidoException {
        if (bonus < 0) {
            throw new SalarioInvalidoException("Bonus não pode ser negativo.");
        }
        return bonus;
    }
}
