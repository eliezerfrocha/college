import java.util.Scanner;

public class ValidaNumeroReal {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        double input = s.nextDouble();

        s.close();
        
        if (input >= 0 && input <= 200) {
            System.out.println("Valido");
        } else if (input < 0 || input > 200) {
            System.out.println("Invalido");
        }
    }
}
