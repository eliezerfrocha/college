import model.Funcionario;
import service.FuncionarioService;

import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final FuncionarioService funcionarioService = new FuncionarioService();

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    gravar();
                    break;
                case "2":
                    exibir();
                    break;
                case "0":
                    System.out.println("\nAté logo! Saindo...");
                    return;
                default:
                    System.out.println("\nOpção inválida. Por favor, tente novamente.\n");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("========= MENU =========");
        System.out.println("1. Gravar");
        System.out.println("2. Exibir");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void gravar() {
        System.out.println("\n--- Cadastro de Funcionário ---");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o cargo: ");
        String cargo = scanner.nextLine();

        try {
            Funcionario funcionario = new Funcionario(nome, cargo);
            funcionarioService.salvar(funcionario);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void exibir() {
        System.out.println("\n--- Lista de Funcionários ---\n");
        String resultado = funcionarioService.exibir();
        System.out.println(resultado);
    }
}