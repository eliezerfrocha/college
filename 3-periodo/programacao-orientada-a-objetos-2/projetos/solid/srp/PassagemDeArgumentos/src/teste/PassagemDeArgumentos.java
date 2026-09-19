package teste;

public class PassagemDeArgumentos {

    public static void main(String[] args) {

        int soma = 0;
        if(args.length<=0)
             System.out.println("Sem argumentos");
        else{
               for(String s : args)
                  soma += Integer.valueOf(s);
             System.out.println("A soma é: "+soma);                
        }
    }
    
}
