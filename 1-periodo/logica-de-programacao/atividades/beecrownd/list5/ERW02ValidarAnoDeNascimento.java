import java.util.Scanner;

public class ERW02ValidarAnoDeNascimento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int ano = scanner.nextInt();

            if (ano >= 1900 && ano <= 2023) {
                System.out.println(ano);
                break;  // Finaliza o programa quando um ano válido é encontrado
            } else {
                System.out.println("Ano invalido");
            }
        }

        scanner.close();
    }
}
