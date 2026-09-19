package ispsolucao;

import ispsolucao.*;

public class Estagiario implements FuncionarioEstagiario{
    private String instituicaoEnsino;

    @Override
    public String getCargo(){
        return "Estagiário";
    }
    
    @Override
    public double calculaSalario(){
// lógica para calcular o salario do estagiário
        return 1500;
    }
     
    @Override
    public void setInstituicaoEnsino(String instituicao){
//  lógica para setar a instituição de ensino do estagiário 
        this.instituicaoEnsino = instituicao;
    }

    @Override
    public String getInstituicaoEnsino(){
        return this.instituicaoEnsino;
    }
}
