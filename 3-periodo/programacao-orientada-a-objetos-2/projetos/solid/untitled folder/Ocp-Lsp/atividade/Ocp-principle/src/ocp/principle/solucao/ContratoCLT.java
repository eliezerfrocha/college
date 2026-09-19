package ocp.principle.solucao;

public class ContratoCLT implements Remuneravel {
    private double salario;
   
    // construtor
    public ContratoCLT(double salario) {
        this.salario = salario;
    }
    
    @Override
    public double remuneracao(){
        return salario;
    }
}

