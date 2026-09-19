
package ispviolacao;

/**
 *
 * @author Clarimundo
 */
public class IspViolacao {

    
    public static void main(String[] args) {
         // lógica da aplicação
        Funcionario programador = new Programador();
        System.out.println("Cargo: " + programador.getCargo());
        System.out.println("Salário: " + programador.calculaSalario());
        System.out.println("13º Salário: " + programador.calcula13o());
        System.out.println();
        Funcionario gerente = new Gerente();
        System.out.println("Cargo: " + gerente.getCargo());
        System.out.println("Salário: " + gerente.calculaSalario());
        System.out.println("13º Salário: " + gerente.calcula13o());
        System.out.println();
        Funcionario estagiario = new Estagiario();
        System.out.println("Cargo: " + estagiario.getCargo());
        System.out.println("Salário: " + estagiario.calculaSalario());
        try {
            System.out.println("13º Salário: " + estagiario.calcula13o());
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
