import java.util.*;

public class SistemaBancario {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, List<ContaBancaria>> contas = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("           MENU PRINCIPAL       ");
            System.out.println("╚══════════════════════════════╝");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Acessar conta");
            System.out.println("3 - Sair");
            System.out.print("\n< Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    acessarConta();
                    break;
                case 3:
                    System.out.println("\n> Saindo...");
                    return;
                default:
                    System.out.println("\n>> Opção inválida! Tente novamente.");
            }
        }
    }

    private static void criarConta() {
        System.out.print("< Digite seu nome: ");
        String nome = scanner.nextLine();
        
        System.out.println("\nEscolha o tipo de conta:");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        System.out.println("3 - Conta Corrente Premium");
        System.out.println("4 - Conta Empresarial");
        System.out.println("5 - Conta Poupança Estudantil");
        System.out.print("< Opção: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("\n< Depósito inicial: R$ ");
        double saldo = scanner.nextDouble();

        ContaBancaria conta = null;
        switch (tipo) {
            case 1:
                conta = new ContaCorrente(nome, saldo);
                break;
            case 2:
                conta = new ContaPoupanca(nome, saldo, 0.5);
                break;
            case 3:
                conta = new ContaCorrentePremium(nome, saldo, 500, 2);
                break;
            case 4:
                conta = new ContaCorrenteEmpresarial(nome, saldo, 1000, 3);
                break;
            case 5:
                conta = new ContaPoupamcaEstudantil(nome, saldo, 0.5, 500);
                break;
            default:
                System.out.println("\n>> Opção inválida!");
                return;
        }
        
        contas.computeIfAbsent(nome, k -> new ArrayList<>()).add(conta);
        System.out.println("\n>> Conta criada com sucesso!");
    }

    private static void acessarConta() {
        System.out.print("< Digite seu nome: ");
        String nome = scanner.nextLine();
        
        if (!contas.containsKey(nome)) {
            System.out.println("\n>> Nenhuma conta encontrada para " + nome);
            return;
        }

        List<ContaBancaria> listaContas = contas.get(nome);
        System.out.println("\n< Escolha uma conta:");
        for (int i = 0; i < listaContas.size(); i++) {
            System.out.println((i + 1) + " - " + listaContas.get(i).getClass().getSimpleName());
        }
        System.out.print("< Opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();
        
        if (escolha < 1 || escolha > listaContas.size()) {
            System.out.println("\n>> Opção inválida!");
            return;
        }

        menuConta(listaContas.get(escolha - 1));
    }

    private static void menuConta(ContaBancaria conta) {
        while (true) {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("         MENU DA CONTA         ");
            System.out.println("╚══════════════════════════════╝");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Exibir Saldo");
            System.out.println("4 - Voltar");
            System.out.print("< Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("< Digite o valor do depósito: R$ ");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    System.out.println("\n>> Depósito realizado!");
                    break;
                case 2:
                    System.out.print("\n< Digite o valor do saque: R$ ");
                    double saque = scanner.nextDouble();
                    if (conta.sacar(saque)) {
                        System.out.println("\n>> Saque realizado!");
                    } else {
                        System.out.println("\n>> Saldo insuficiente!");
                    }
                    break;
                case 3:
                    System.out.println(conta.exibeSaldo());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("\n>> Opção inválida! Tente novamente.");
            }
        }
    }
}
