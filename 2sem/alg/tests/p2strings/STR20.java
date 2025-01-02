package tests.p2strings;

import java.util.Scanner;

public class STR20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String frase = scanner.nextLine();
        String[] words = frase.split(" ");

        int resultado = 1;

        for (String word : words) {
            int soma = sumDigits(word);
            if (soma == 0) {
                soma = 1;
            }
            resultado *= soma;
        }

        System.out.println("Resultado = " + resultado);

        scanner.close();
    }

    private static int sumDigits(String palavra) {
        int soma = 0;
        for (char ch : palavra.toCharArray()) {
            if (Character.isDigit(ch)) {
                soma += Character.getNumericValue(ch);
            }
        }
        return soma;
    }
}
