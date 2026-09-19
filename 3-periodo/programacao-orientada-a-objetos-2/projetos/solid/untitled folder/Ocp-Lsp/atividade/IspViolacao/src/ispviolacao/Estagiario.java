package ispviolacao;

public class Estagiario implements Funcionario{
    
    @Override
    public String getCargo(){
        return "Estagiário";
    }
    
    @Override
    public double calculaSalario(){
        // lógica para calcular o salario do estagiário
        return 1000.00;
    }
     
    @Override
    public double calcula13o(){
        throw new UnsupportedOperationException("Estagiário não pode receber 13o");
    }
}
