package interfaces;

import model.exceptions.SalarioInvalidoException;

public interface Pagavel {
    public abstract double calcularSalario() throws SalarioInvalidoException;
} 
