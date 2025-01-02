package tests.p2strings;

import java.util.Scanner;

public class STR18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String frase = scanner.nextLine();
        char caractere = scanner.next().charAt(0);
        
        int quantidade = contarOcorrencias(frase, caractere);
        String novaFrase = formarNovaFrase(frase, caractere);

        System.out.println(quantidade);
        System.out.println(novaFrase);

        scanner.close();
    }

    private static int contarOcorrencias(String frase, char c) {
        int count = 0;
        char lowerC = Character.toLowerCase(c);
        for (char ch : frase.toCharArray()) {
            if (Character.toLowerCase(ch) == lowerC) {
                count++;
            }
        }
        return count;
    }

    private static String formarNovaFrase(String frase, char c) {
        StringBuilder novaFrase = new StringBuilder();
        char lowerC = Character.toLowerCase(c);
        String[] palavras = frase.split(" ");
        for (String palavra : palavras) {
            if (palavra.toLowerCase().indexOf(lowerC) != -1) {
                if (novaFrase.length() > 0) {
                    novaFrase.append(" ");
                }
                novaFrase.append(palavra);
            }
        }
        return novaFrase.toString();
    }
}



