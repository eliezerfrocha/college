import java.util.Scanner;

public class OddNumbers {
    public static void main(String[] args) {
        System.out.println();
        Scanner s = new Scanner(System.in);
        
        // Lê o valor de entrada
        int X = s.nextInt();

        s.close();
        
        // Garantir que X seja ímpar, se for par, incrementar por 1
        if (X % 2 == 0) {
            X++;
        }

        // Usar um loop for para imprimir os 6 números ímpares consecutivos
        for (int i = 0; i < 6; i++) {
            System.out.println(X);
            X += 2; // Incrementar por 2 para garantir que o próximo número também seja ímpar
        }

        System.out.println();
    }
}
