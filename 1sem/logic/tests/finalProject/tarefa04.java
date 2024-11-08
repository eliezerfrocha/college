/* 
    TRABALHO FINAL – Vetores e matrizes
    Prof. Bruno Queiroz Pinto

    Aluno: Eliezer Ferreira Rocha
*/ 

import java.util.Scanner;

// Companhia telefonica
public class tarefa04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------");

        // Lê a quantidade de clientes
        System.out.print("> Informe a quantidade de clientes: ");
        int numClientes = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        // Arrays para armazenar os dados dos clientes
        String[] nomes = new String[numClientes];
        String[] telefones = new String[numClientes];
        int[] tiposAssinatura = new int[numClientes];
        int[] minutosConsumidos = new int[numClientes];
        double[] valoresConta = new double[numClientes];

        // Lê os dados dos clientes
        for (int i = 0; i < numClientes; i++) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("> Dados do " + (i + 1) + "º cliente:");
            System.out.print("> Nome: ");
            nomes[i] = scanner.nextLine();
            System.out.print("> Telefone: ");
            telefones[i] = scanner.nextLine();
            System.out.print("> Tipo: ");
            tiposAssinatura[i] = scanner.nextInt();
            System.out.print("> Minutos: ");
            minutosConsumidos[i] = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner
        }

        // Lê os preços básicos e dos minutos excedentes
        System.out.println("-----------------------------------------------------------------");
        double[][] precos = new double[3][2];
        System.out.println("> Informe o preco basico e excedente de cada tipo de conta:");
        for (int i = 0; i < 3; i++) {
            System.out.print("> Tipo " + i + ": ");
            precos[i][0] = scanner.nextDouble(); // Preço da assinatura
            precos[i][1] = scanner.nextDouble(); // Preço do minuto excedente
        }
        scanner.nextLine(); // Limpa o buffer do scanner

        // Calcula o valor da conta para cada cliente
        int minutosIncluidos = 90;
        for (int i = 0; i < numClientes; i++) {
            int tipo = tiposAssinatura[i];
            double precoAssinatura = precos[tipo][0];
            double precoMinutoExcedente = precos[tipo][1];
            int minutosExcedentes = Math.max(0, minutosConsumidos[i] - minutosIncluidos);

            if (minutosConsumidos[i] <= minutosIncluidos) {
                valoresConta[i] = precoAssinatura;
            } else {
                valoresConta[i] = precoAssinatura + (minutosExcedentes * precoMinutoExcedente);
            }
        }

        // Menu de opções
        int opcao;
        do {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("MENU DE OPCOES:");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("1) Relatório de clientes");
            System.out.println("2) A receita total");
            System.out.println("3) Nome e telefone do cliente com a conta mais barata");
            System.out.println("4) Média de minutos consumidos por clientes de conta tipo 1");
            System.out.println("5) Quantidade de clientes que consumiram acima de 120 minutos");
            System.out.println("6) Percentual de clientes tipo 2");
            System.out.println("7) Imprimir tabela de clientes");
            System.out.println("8) Sair");
            System.out.println("-----------------------------------------------------------------");
            System.out.print("> Informe uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    // Relatório de clientes
                    System.out.println("\n");
                    System.out.println("> Relatório de clientes:");
                    for (int i = 0; i < numClientes; i++) {
                        System.out.printf("%s, %s, Tipo %d, Minutos: %d, Conta = R$ %.2f%n",
                                nomes[i], telefones[i], tiposAssinatura[i], minutosConsumidos[i], valoresConta[i]);
                    }
                    System.out.println("\n");
                    break;

                case 2:
                    // Receita total
                    System.out.println("\n");
                    double receitaTotal = 0;
                    for (double valor : valoresConta) {
                        receitaTotal += valor;
                    }
                    System.out.printf("> A receita total é R$ %.2f%n", receitaTotal);
                    System.out.println("\n");
                    break;

                case 3:
                    // Conta mais barata
                    System.out.println("\n");
                    int indiceMenorConta = 0;
                    for (int i = 1; i < numClientes; i++) {
                        if (valoresConta[i] < valoresConta[indiceMenorConta]) {
                            indiceMenorConta = i;
                        }
                    }
                    System.out.printf("> Nome e telefone do cliente com a conta mais barata: %s, %s%n",
                            nomes[indiceMenorConta], telefones[indiceMenorConta]);
                    System.out.println("\n");
                    break;

                case 4:
                    // Média de minutos consumidos por clientes tipo 1
                    System.out.println("\n");
                    int totalMinutosTipo1 = 0;
                    int countTipo1 = 0;
                    for (int i = 0; i < numClientes; i++) {
                        if (tiposAssinatura[i] == 1) {
                            totalMinutosTipo1 += minutosConsumidos[i];
                            countTipo1++;
                        }
                    }
                    double mediaMinutosTipo1 = (countTipo1 > 0) ? (double) totalMinutosTipo1 / countTipo1 : 0;
                    System.out.printf("> Média de minutos consumidos por clientes tipo 1: %.2f%n", mediaMinutosTipo1);
                    System.out.println("\n");
                    break;

                case 5:
                    // Quantidade de clientes que consumiram acima de 120 minutos
                    System.out.println("\n");
                    int countAcima120 = 0;
                    for (int minutos : minutosConsumidos) {
                        if (minutos > 120) {
                            countAcima120++;
                        }
                    }
                    System.out.printf("> Quantidade de clientes que consumiram acima de 120 minutos: %d%n",
                            countAcima120);
                    System.out.println("\n");
                    break;

                case 6:
                    // Percentual de clientes tipo 2
                    System.out.println("\n");
                    int countTipo2 = 0;
                    for (int tipo : tiposAssinatura) {
                        if (tipo == 2) {
                            countTipo2++;
                        }
                    }
                    double percentualTipo2 = (numClientes > 0) ? (double) countTipo2 / numClientes * 100 : 0;
                    System.out.printf("> Percentual de clientes tipo 2: %.1f%%%n", percentualTipo2);
                    System.out.println("\n");
                    break;

                case 7:
                    // Imprimir tabela de clientes
                    System.out.println("\n");
                    System.out.println("-----------------------------------------------------------------");
                    System.out.printf("%-20s %-15s %-4s %-7s %-15s%n", "Nome", "Telefone", "Tipo", "Minutos",
                            "Valor da Conta");
                    System.out.println("-----------------------------------------------------------------");
                    for (int i = 0; i < nomes.length; i++) {
                        System.out.printf("%-20s %-15s %-4d %-7d R$%-14.2f%n", nomes[i], telefones[i],
                                tiposAssinatura[i], minutosConsumidos[i], valoresConta[i]);
                    }
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("\n");
                    break;

                case 8:
                    // Sair
                    System.out.println("\n");
                    System.out.println("> FIM DO PROGRAMA!");
                    System.out.println("\n");
                    break;

                default:
                    System.out.println("\n");
                    System.out.println("> Opção inválida! Tente novamente.");
                    System.out.println("\n");
                    break;
            }
        } while (opcao != 8);

        scanner.close();
    }
}