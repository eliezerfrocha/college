
package ispsolucao;

/**
 *
 * @author Clarimundo
 */
public class IspSolucao {

    
    public static void main(String[] args) {
         // lógica da aplicação
        FuncionarioCeletista programador = new Programador();
        System.out.println("Cargo: " + programador.getCargo());
        System.out.println("Salário: " + programador.calculaSalario());
        System.out.println("13º Salário: " + programador.calcula13o());
        System.out.println();
        FuncionarioCeletista gerente = new Gerente();
        System.out.println("Cargo: " + gerente.getCargo());
        System.out.println("Salário:s " + gerente.calculaSalario());
        System.out.println("13º Salário: " + gerente.calcula13o());
        System.out.println();
        FuncionarioEstagiario estagiario = new Estagiario();
        System.out.println("Cargo: " + estagiario.getCargo());
        System.out.println("Salário: " + estagiario.calculaSalario());

        estagiario.setInstituicaoEnsino("IFTM - Instituto Federal do Triângulo Mineiro");
        System.out.println("Instituição de Ensino: " + estagiario.getInstituicaoEnsino());
    }
    
}
