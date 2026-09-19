package ocp.principle.solucao;

public class ContratoEstagio implements Remuneravel {
    private double bolsa;

    // construtor
    public ContratoEstagio(double bolsa) {
        this.bolsa = bolsa;
    }
    
    @Override
    public double remuneracao() {
         return bolsa;  }
    
}

