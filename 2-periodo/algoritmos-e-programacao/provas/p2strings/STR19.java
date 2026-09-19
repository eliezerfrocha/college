package tests.p2strings;

import java.util.Scanner;

public class STR19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String frase = scanner.nextLine();

        char char1 = scanner.next().charAt(0);
        char char2 = scanner.next().charAt(0);

        int count1 = contarOcorrencias(frase, char1);
        int count2 = contarOcorrencias(frase, char2);

        if (count1 > count2) {
            System.out.println(char1);
        } else if (count2 > count1) {
            System.out.println(char2);
        } else {
            System.out.println("empate");
        }

        scanner.close();
    }

    private static int contarOcorrencias(String frase, char c) {
        int count = 0;
        for (char ch : frase.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }
}