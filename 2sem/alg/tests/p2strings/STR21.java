package tests.p2strings;

import java.util.Scanner;

// Validar CNPJ
public class STR21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Insira o cnpj a ser validado:");
        System.out.print("> ");
        
        String cnpj = scanner.nextLine();
        String regex = "([0-9]{2}\\.?[0-9]{3}\\.?[0-9]{3}\\/?[0-9]{4}|[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3})-?[0-9]{2}";

        if (cnpj.matches(regex)) {
            System.out.println("CNPJ válido");
        } else {
            System.out.println("CNPJ inválido");
        }

        scanner.close();
    }
}
// 12.345.678/0001-95 - CNPJ válido
// 12345/6780001-95 - CNPJ inválido