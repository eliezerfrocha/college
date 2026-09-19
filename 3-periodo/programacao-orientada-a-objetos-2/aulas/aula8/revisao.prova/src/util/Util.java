package util;

import java.text.NumberFormat;

public class Util {
    public static String formatarMoeda(double valor) {
        return NumberFormat.getCurrencyInstance().format(valor);
    }

    public static String formatarCPF(String cpf) {
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public static String formatarNome(String nome) {
        return nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
    }
}
