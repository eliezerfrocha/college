package ex1;

import java.util.Scanner;

public class ProgramaValidacao {
    private static void validarTelefone(String telefone) throws Validacao {
        if (!telefone.matches("\\d{10,11}")) {
            throw new Validacao("Telefone inválido! Deve conter 10 ou 11 dígitos.");
        }
    }

    public static void quebrarLinha() {
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuarioSistema = new Usuario("admin", "1234");

        try {
            quebrarLinha();

            System.out.print("> Digite o usuário: ");
            String usuarioInput = scanner.nextLine();
            System.out.print("> Digite a senha: ");
            String senhaInput = scanner.nextLine();

            quebrarLinha();
            usuarioSistema.validarLogin(usuarioInput, senhaInput);
            System.out.println(">> Usuário e senha validados com sucesso!");
            quebrarLinha();

            System.out.print("> Digite o nome: ");
            String nome = scanner.nextLine();
            System.out.print("> Digite o telefone: ");
            String telefone = scanner.nextLine();

            validarTelefone(telefone);
            quebrarLinha();
            System.out.println(">> Dados cadastrados com sucesso!");
            quebrarLinha();
            System.out.println("> Nome: " + nome);
            System.out.println("> Telefone: " + telefone);

        } catch (Validacao e) {
            quebrarLinha();
            System.out.println(">> Erro: " + e.getMessage());
            quebrarLinha();
        } finally {
            scanner.close();
        }
    }
}
