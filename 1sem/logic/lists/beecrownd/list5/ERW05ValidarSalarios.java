import java.util.Scanner;

public class ERW05ValidarSalarios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalSalario = 0.0;
        int count = 0;

        while (true) {
            double salario = scanner.nextDouble();

            if (salario < 0 || salario > 100000) {
                break;  // Finaliza o programa se o salário for negativo ou superior a 100000
            }

            totalSalario += salario;
            count++;
        }

        // Calcular a média salarial
        double mediaSalarios = totalSalario / count;

        // Imprimir o resultado formatado
        System.out.printf("R$ %.2f%n", mediaSalarios);

        scanner.close();
    }
}
