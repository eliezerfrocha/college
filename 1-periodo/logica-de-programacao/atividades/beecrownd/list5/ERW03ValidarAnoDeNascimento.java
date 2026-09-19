import java.util.Scanner;

public class ERW03ValidarAnoDeNascimento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double totalSalario = 0.0;
        int count = 0;
        int menorIdade = Integer.MAX_VALUE;
        int maiorIdade = Integer.MIN_VALUE;
        int mulheresAcima3000 = 0;

        while (true) {
            // Ler os dados do entrevistado
            int idade = scanner.nextInt();
            char sexo = scanner.next().charAt(0);
            double salario = scanner.nextDouble();
            char continuar = scanner.next().charAt(0);

            // Atualizar os dados
            totalSalario += salario;
            count++;
            if (idade < menorIdade) {
                menorIdade = idade;
            }
            if (idade > maiorIdade) {
                maiorIdade = idade;
            }
            if (sexo == 'f' && salario > 3000.00) {
                mulheresAcima3000++;
            }

            // Verificar se deve parar a leitura
            if (continuar == 'n') {
                break;
            }
        }

        // Calcular a média salarial
        double mediaSalarios = totalSalario / count;

        // Imprimir os resultados
        System.out.printf("Media salarios = R$ %.2f%n", mediaSalarios);
        System.out.printf("Menor e maior idade = %d e %d%n", menorIdade, maiorIdade);
        System.out.printf("Salarios de mulheres acima de R$ 3000.00 = %d%n", mulheresAcima3000);

        scanner.close();
    }
}
