package academia;

import java.util.Random;
import java.util.regex.Pattern;

public class Utilitaria {
    public static String geraCodigo() {
        Random random = new Random();
        String letras = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder codigo = new StringBuilder();
        
        for (int i = 0; i < 3; i++) {
            codigo.append(letras.charAt(random.nextInt(letras.length())));
        }
        for (int i = 0; i < 2; i++) {
            codigo.append(random.nextInt(10));
        }
        return codigo.toString();
    }
    
    public static boolean validaTel(String telefone) {
        String regex = "\\(3[1-9]\\) 9[89][0-9]{3}-[0-9]{4}";
        return Pattern.matches(regex, telefone);
    }
}

package academia;

public class Academia {
    private int alunos;
    static int acessos;

    public Academia() {
        this.alunos = 0;
    }

    public void atualiza(int novosAlunos) {
        this.alunos += novosAlunos;
    }
}

package aplicacao;

public class Aluno {
    private String codigo;
    private String nome;
    private String telefone;
    private int categoria;
    int acessos;
    
    public Aluno(String codigo, String nome, String telefone, int categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.categoria = categoria;
        this.acessos = 0;
    }

    public Aluno(String codigo, String nome, String telefone, int categoria, int acessos) {
        this(codigo, nome, telefone, categoria);
        this.acessos = acessos;
    }
    
    public String exibe() {
        return String.format("Código: %s\nNome: %s\nTelefone: %s\nCategoria: %d", codigo, nome, telefone, categoria);
    }
    
    public String exibe(int acessos) {
        return exibe() + String.format("\nAcessos: %d", acessos);
    }
}

package tests.rascunho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import academia.Utilitaria;
import academia.Academia;

public class App {
    private static final List<Aluno> alunos = new ArrayList<>();
    private static final String[][] funcionarios = {
        {"admin1", "senha1"},
        {"admin2", "senha2"},
        {"admin3", "senha3"}
    };
    
    public static void main(String[] args) {
        menu();
    }
    
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("M E N U\n1- ACADEMIA\n2- PERSONAL\n3- SAIR\nDIGITE A OPÇÃO: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            if (opcao == 1) {
                if (validaFuncionario(scanner)) {
                    subMenu(scanner);
                }
            } else if (opcao == 2) {
                System.out.println("Opção 2 ainda não implementada.");
            } else if (opcao == 3) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
    
    private static boolean validaFuncionario(Scanner scanner) {
        int tentativas = 0;
        while (tentativas < 3) {
            System.out.print("Usuário: ");
            String usuario = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();
            
            for (String[] funcionario : funcionarios) {
                if (funcionario[0].equals(usuario) && funcionario[1].equals(senha)) {
                    return true;
                }
            }
            System.out.println("Usuário ou senha incorretos.");
            tentativas++;
        }
        System.out.println("Número de tentativas esgotado. Encerrando...");
        return false;
    }
    
    private static void subMenu(Scanner scanner) {
        while (true) {
            System.out.println("S u b M E N U\n1- CADASTRO\n2- RELATÓRIO\n3- VOLTAR\nDIGITE A OPÇÃO: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            if (opcao == 1) {
                cadastrarAluno(scanner);
            } else if (opcao == 2) {
                gerarRelatorio();
            } else if (opcao == 3) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
    
    private static void cadastrarAluno(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        for (Aluno a : alunos) {
            if (a.exibe().contains(nome)) {
                System.out.println("Aluno já cadastrado!");
                return;
            }
        }
        
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        if (!Utilitaria.validaTel(telefone)) {
            System.out.println("Telefone inválido!");
            return;
        }
        
        System.out.print("Categoria (1, 2 ou 3): ");
        int categoria = scanner.nextInt();
        scanner.nextLine();
        if (categoria < 1 || categoria > 3) {
            System.out.println("Categoria inválida!");
            return;
        }
        
        String codigo = Utilitaria.geraCodigo();
        alunos.add(new Aluno(codigo, nome, telefone, categoria));
        System.out.println("Aluno cadastrado com sucesso!");
    }
    
    private static void gerarRelatorio() {
        System.out.println("RELATÓRIO");
        for (Aluno a : alunos) {
            System.out.println(a.exibe());
        }
        System.out.println("TOTAL DE ALUNOS = " + alunos.size());
    }
}
