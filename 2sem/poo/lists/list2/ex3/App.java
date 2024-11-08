package ex3;
import java.util.Scanner;

public class App {
    static Scanner s = new Scanner(System.in);

    public static Pessoa lePessoa() {
        System.out.println("Digite nome:");
        String nome = s.nextLine();
        
        System.out.println("Digite sexo:");
        char sexo = s.next().charAt(0);
        
        System.out.println("Digite idade:");
        int idade = s.nextInt();
        
        Pessoa p = new Pessoa(nome, sexo, idade);
        return p;
    }

    public static Formacao leFormacao() {
        System.out.println("Digite nome:");
        String nome = s.nextLine();

        System.out.println("Digite instituição:");
        String instituicao = s.nextLine();
        
        System.out.println("Digite sexo:");
        boolean concluido = s.nextBoolean();
        
        System.out.println("Digite ano:");
        int ano = s.nextInt();

        Formacao f = new Formacao()
        return f;
    }

    public static void Menu() {
        
    }

    public static void main(String[] args) {
        
    }
}
