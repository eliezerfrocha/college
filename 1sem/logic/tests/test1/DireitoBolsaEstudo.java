import java.util.Scanner;

public class DireitoBolsaEstudo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        double n = s.nextDouble();
        int f = s.nextInt();
        double r = s.nextDouble();

        s.close();

        if (n >= 8.0 && f <= 10 && r < 2000.00 || n >= 9.5 && f == 0 ) {
            System.out.println("Pode receber bolsa");
        } else {
            System.out.println("Não pode receber bolsa");
        }
    }
}
