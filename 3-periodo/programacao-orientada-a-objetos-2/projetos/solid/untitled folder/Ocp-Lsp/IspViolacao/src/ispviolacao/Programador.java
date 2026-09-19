package ispviolacao;

public class Programador implements Funcionario {
    
    @Override
    public String getCargo(){
        return "Programador";
    }
    
    @Override
    public double calculaSalario(){
// lógica para calcular o salario do programador
        return 4000;            
    }
        
    @Override
    public double calcula13o(){
// lógica para calcular o décimo terceiro salario
        return this.calculaSalario() / 12;                //do programador
    }    
}
