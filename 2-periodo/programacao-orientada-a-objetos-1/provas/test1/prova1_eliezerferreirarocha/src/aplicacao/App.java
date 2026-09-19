package aplicacao;

import java.util.ArrayList;
import java.util.Scanner;
import academia.Academia;
import academia.Utilitaria;

public class App {
    private static final ArrayList<Aluno> listaAlunos = new ArrayList<>();
    private static final String[][] funcionarios = { { "func1", "senha1" }, { "func2", "senha2" }, { "func3", "senha3" } };
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        exibirMenuPrincipal();
    }

    public static void exibirMenuPrincipal() {
        int opcao;

        do {
            System.out.println("\n================ MENU PRINCIPAL ================\n");
            System.out.println("1 - ACADEMIA");
            System.out.println("2 - PERSONAL");
            System.out.println("3 - SAIR");
            System.out.println("\n================================================\n");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> exibirSubMenuAcademia();
                case 2 -> acessarPersonal();
                case 3 -> System.out.println("\nEncerrando o sistema... Até logo!");
                default -> System.out.println("\nOpção inválida! Tente novamente.");
            }
        } while (opcao != 3);
    }

    public static void exibirSubMenuAcademia() {
        if (!validarFuncionario()) {
            System.out.println("\nNúmero de tentativas esgotado. Voltando ao menu principal...");
            return;
        }

        int opcao;

        do {
            System.out.println("\n================= SUBMENU ACADEMIA =================\n");
            System.out.println("1 - CADASTRAR ALUNO");
            System.out.println("2 - EXIBIR RELATÓRIO DE ALUNOS");
            System.out.println("3 - VOLTAR");
            System.out.println("\n===================================================\n");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> exibirRelatorio();
                case 3 -> System.out.println("\nVoltando ao menu principal...");
                default -> System.out.println("\nOpção inválida! Tente novamente.");
            }
        } while (opcao != 3);
    }

    private static boolean validarFuncionario() {
        int tentativas = 0;

        while (tentativas < 3) {
            System.out.println("\n================= LOGIN FUNCIONÁRIO =================\n");
            System.out.print("Usuário: ");
            String usuario = scanner.next();

            System.out.print("Senha: ");
            String senha = scanner.next();

            for (String[] funcionario : funcionarios) {
                if (funcionario[0].equals(usuario) && funcionario[1].equals(senha)) {
                    System.out.println("\nLogin efetuado com sucesso!");
                    return true;
                }
            }

            tentativas++;
            System.out.println("\nUsuário ou senha inválidos! Tentativa " + tentativas + "/3");
        }

        return false;
    }

    private static void cadastrarAluno() {
        System.out.println("\n=========== CADASTRO DE NOVO ALUNO ===========\n");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        for (Aluno aluno : listaAlunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println("\nAluno já cadastrado!");
                return;
            }
        }

        System.out.print("Telefone (formato: (xx) xxxxx-xxxx): ");
        String telefone = scanner.nextLine();
        if (!Utilitaria.validarTelefone(telefone)) {
            System.out.println("\nTelefone inválido! Cadastro cancelado.");
            return;
        }

        System.out.print("Categoria (1, 2 ou 3): ");
        int categoria = scanner.nextInt();
        scanner.nextLine();
        if (categoria < 1 || categoria > 3) {
            System.out.println("\nCategoria inválida! Cadastro cancelado.");
            return;
        }

        String codigo = Utilitaria.gerarCodigoAluno();
        Aluno novoAluno = new Aluno(codigo, nome, telefone, categoria);

        listaAlunos.add(novoAluno);
        System.out.println("\nAluno cadastrado com sucesso!");
    }

    private static void exibirRelatorio() {
        System.out.println("\n============== RELATÓRIO DE ALUNOS ==============\n");

        if (listaAlunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : listaAlunos) {
                aluno.exibirInformacoes();
            }
        }
    }

    private static void acessarPersonal() {
        if (!validarFuncionario()) {
            System.out.println("\nNúmero de tentativas esgotado. Voltando ao menu principal...");
            return;
        }

        System.out.print("\nCódigo do aluno: ");
        String codigo = scanner.next();

        Aluno aluno = (Aluno) listaAlunos.stream()
                .filter(a -> a.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);

        if (aluno == null) {
            System.out.println("\nAluno não encontrado!");
        } else if (!Aluno.aumentarAcessosPersonal()) {
            System.out.println("\nLimite de acessos ao personal atingido para este aluno.");
        } else if (!Academia.aumentarAcessosPersonal()) {
            System.out.println("\nNúmero máximo de aulas com personal atingido na academia!");
        } else {
            System.out.println("\nAcesso ao personal registrado com sucesso!");
        }
    }
}
