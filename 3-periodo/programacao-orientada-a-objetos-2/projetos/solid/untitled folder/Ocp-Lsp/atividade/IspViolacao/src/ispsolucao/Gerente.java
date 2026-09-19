package ispsolucao;

import ispviolacao.*;

public class Gerente implements FuncionarioCeletista{
    
    @Override
    public String getCargo(){
        return "Gerente";
    }
    
    @Override
    public double calculaSalario(){
        // lógica para calcular o salario do gerente
        return 3000;
    }
    
    @Override
    public double calcula13o(){
        // lógica para calcular o décimo terceiro salario 
        return this.calculaSalario() / 12;                   // do gerente
    }
}
