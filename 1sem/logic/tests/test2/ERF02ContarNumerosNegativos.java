import java.util.Scanner;

public class ERF02ContarNumerosNegativos {
    public static void main(String[] args) {    
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();
        int negativos = 0;

        s.close();

        for (int i = 0; i < num ; i++) {
            int n = s.nextInt();
            if(n < 0) { negativos++; }    
        }

        System.out.println(negativos);
    }
}