package academia;

import java.util.Random;

public class Utilitaria {
    public static String gerarCodigoAluno() {
        Random random = new Random();
        char letra1 = (char) (random.nextInt(26) + 'A');
        char letra2 = (char) (random.nextInt(26) + 'A');
        char letra3 = (char) (random.nextInt(26) + 'A');

        int digito1 = random.nextInt(10);
        int digito2 = random.nextInt(10);

        return "" + letra1 + letra2 + letra3 + digito1 + digito2;
    }

    public static boolean validarTelefone(String telefone) {
        if (!telefone.matches("\\(\\d{2}\\) \\d{5}-\\d{4}")) {
            return false;
        }

        String somenteNumeros = telefone.replaceAll("[^\\d]", "");
        if (somenteNumeros.charAt(0) != '3')
            return false;
        if (somenteNumeros.charAt(1) == '6' || somenteNumeros.charAt(1) == '0')
            return false;
        if (somenteNumeros.charAt(2) != '9')
            return false;

        return true;
    }
}