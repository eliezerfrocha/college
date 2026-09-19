
package prog5tratamento;

/**
 *
 * @author Clarimundo
 */
public class DvisaoNaoExata extends Exception {
    private int num, den;
    
    public DvisaoNaoExata(int num, int den){
        super();
        this.num = num;
        this.den = den;
    }
        
    @Override
    public String toString(){
        return "Resultado de "+ num + "/" + den + " não é inteiro";
    }
}
