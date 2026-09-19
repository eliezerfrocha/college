package banco;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class App {
    public static ContaCorrente leDados() {
        Scanner s = new Scanner(System.in);

        System.out.println("< Digite o nome do cliente: ");
        String nome = s.nextLine();
        System.out.println("< Digite o número da conta: ");
        String nomeConta = s.nextLine();
        System.out.println("< Digite o saldo inicial da conta: ");
        double saldo = s.nextDouble();

        System.out.println("< A conta é comum ou especial? (Digite 'comum' ou 'especial') ");
        String tipoConta = s.next();
        s.close();

        if (tipoConta.equalsIgnoreCase("comum")) {
            return new ContaCorrente(nome, nomeConta, saldo); // conta comum
        } else {
            System.out.println("< Digite o limite da conta especial: ");
            double limite = s.nextDouble();
            return new ContaCorrente(nome, nomeConta, saldo, limite); // conta especial
        }
    }

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner s = new Scanner(System.in);
        String[] clientesBanco = { "Maria", "Joao", "Carlos" };
        ContaCorrente conta = null;

        while (true) {
            System.out.println("\n-----------------------------------------");
            System.out.println("-------------- Bank System --------------");
            System.out.println("-----------------------------------------");
            System.out.println("Menu:");
            System.out.println("-----------------------------------------");   
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Depositar");
            System.out.println("4 - Exibir");
            System.out.println("5 - Sair");
            System.out.println("----------------------------------------"); 
            System.out.print("< Escolha uma opção: ");
            int opcao = s.nextInt();
            s.nextLine();
            System.out.println("----------------------------------------"); 

            switch (opcao) {
                case 1:
                    conta = leDados(s, clientesBanco);
                    break;
                case 2:
                    if (conta != null) {
                        System.out.print("< Digite o valor a sacar: ");
                        double saque = s.nextDouble();
                        System.out.print("< Digite o tempo da conta em meses: ");
                        int meses = s.nextInt();
                        double taxa = calcularTaxa(meses, saque);
                        boolean sacou = conta.sacar(saque + taxa);

                        if (sacou)
                            System.out.println("> Saque realizado com sucesso.");
                        else
                            System.out.println("> Saque não permitido.");
                    } else {
                        System.out.println("> Nenhuma conta cadastrada.");
                    }
                    break;
                case 3:
                    if (conta != null) {
                        System.out.print("< Digite o valor a depositar: ");
                        double deposito = s.nextDouble();
                        conta.depositar(deposito);

                        System.out.println("> Depósito realizado com sucesso.");
                    } else {
                        System.out.println("> Nenhuma conta cadastrada.");
                    }
                    break;
                case 4:
                    if (conta != null) {
                        System.out.println(conta.exibe());
                    } else {
                        System.out.println("> Nenhuma conta cadastrada.");
                    }
                    break;
                case 5:
                    System.out.println("> Saindo...");
                    s.close();
                    return;
                default:
                    System.out.println("> Opção inválida!");
            }
        }
    }

    public static ContaCorrente leDados(Scanner scanner, String[] clientesBanco) {
        System.out.print("< Digite seu nome: ");
        String nome = scanner.nextLine();

        if (!Validacao.validaCliente(nome, clientesBanco)) {
            System.out.println("> Cliente não pertence ao banco.");
            return null;
        }

        System.out.print("< Digite o número da conta: ");
        String numeroConta = scanner.nextLine();
        System.out.print("< Digite o saldo inicial: ");
        double saldo = scanner.nextDouble();
        System.out.print("< A conta é especial? (s/n): ");
        char tipo = scanner.next().charAt(0);

        if (tipo == 'S' || tipo == 's') {
            System.out.print("< Digite o limite: ");
            double limite = scanner.nextDouble();
            return new ContaCorrente(nome, numeroConta, saldo, limite);
        } else {
            return new ContaCorrente(nome, numeroConta, saldo);
        }
    }

    public static double calcularTaxa(int meses, double saque) {
        int months = (int)ChronoUnit.MONTHS.between(LocalDate.now().minusMonths(meses),LocalDate.now());
        int categoria = Categoria.defineCategoria(months);

        switch (categoria) {
            case 1:
                return saque * 0.01;
            case 2:
                return saque * 0.005;
            case 3:
                return saque * 0.001;
            default:
                return 0;
        }
    }
}