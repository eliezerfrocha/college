import java.util.Scanner; 

public class ERF01EncontrarOMaiorNumero {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt(); 
        int maior = Integer.MIN_VALUE; 

        s.close();

        int counter = 0; 
        while (counter < n) { 
            int num = s.nextInt(); 
            if (num > maior) {  maior = num; }
            counter++; 
        }

        System.out.println("Maior = " + maior); 
    }
}