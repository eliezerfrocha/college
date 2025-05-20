package prog5tratamento;

/**
 *
 * @author Clarimundo
 */
public class Prog5Tratamento {

    
    public static void main(String[] args) {
        
        int [] num = {4,8,5,16,32,21,64,128,62,80, 90};
        int [] den = {2,0,4,8,0,2,4};
        
        for(int i=0; i<num.length; i++)
            try{
                if(num[i] % 2 != 0)
         //           throw new ArithmeticException();
         //          throw new Exception("Numerador ímpar não dá divisao inteira");
                   throw new DvisaoNaoExata(num[i],den[i]);
                System.out.println(num[i] + "/" + den[i] + "=" + (num[i]/den[i]));
            }
       /*     catch(ArithmeticException | ArrayIndexOutOfBoundsException ex){
                System.out.println("Deu exceção");                
            } 
        */    catch(ArithmeticException | ArrayIndexOutOfBoundsException  ex1){
                System.out.println("Aconteceu um Erro: "+ex1.getMessage());
            }         
              catch(DvisaoNaoExata ex){
                System.out.println(ex.toString());
            }
              
    }
    
}
