import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NumberFrequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] numeros = new int[N];
        
        for (int i = 0; i < N; i++) {
            numeros[i] = scanner.nextInt();
        }

        Arrays.sort(numeros);
        int contador = 1;
        for (int i = 1; i < N; i++) {
            if (numeros[i] == numeros[i - 1]) {
                contador++;
            } else {
                System.out.println(numeros[i - 1] + " aparece " + contador + " vez(es)");
                contador = 1;
            }
        }

        System.out.println(numeros[N - 1] + " aparece " + contador + " vez(es)");  
        scanner.close();
    }
}
