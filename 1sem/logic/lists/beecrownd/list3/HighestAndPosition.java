import java.util.Scanner;

public class HighestAndPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int highestValue = Integer.MIN_VALUE;
        int position = 0;
        
        // Lê 100 números e encontra o maior valor e sua posição
        for (int i = 1; i <= 100; i++) {
            int currentNumber = scanner.nextInt();
            
            if (currentNumber > highestValue) {
                highestValue = currentNumber;
                position = i;
            }
        }
        
        // Imprime o maior valor e a posição
        System.out.println(highestValue);
        System.out.println(position);
        
        scanner.close();
    }
}
