import java.util.Scanner;

public class MerecoSerAprovado {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        double n = s.nextDouble();
        double x = (n*100)/22;

        s.close();

        if (n < 0 || n > 22) {
            System.out.printf("Nota invalida.\n");
        } else {
            System.out.printf("Eu espero tirar %.2f%% da nota.\n", x);
        }
    }
}
