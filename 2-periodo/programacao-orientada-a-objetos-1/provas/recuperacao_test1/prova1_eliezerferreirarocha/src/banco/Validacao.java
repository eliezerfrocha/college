package banco;

public class Validacao {
    public static boolean validaSaque(double saldo, double valor) {
        return valor > 0 && saldo >= valor; // verificação para conta comum
    }

    public static boolean validaSaque(double saldo, double limite, double valor) {
        if (valor > 0) {
            if (saldo >= valor) {
                return true; // saque possível com saldo suficiente
            } else if (saldo > 0) {
                if (valor - saldo <= limite) {
                    return true; // saque possível com saldo + limite
                }
            } else if (limite + saldo >= valor) {
                return true; // saque possível com limite
            }
        }
        return false;
    }

    public static boolean validaCliente(String nome, String[] clientes) {
        if (clientes == null || nome == null) {
            return false;
        }
        for (String cliente : clientes) {
            if (nome.equalsIgnoreCase(cliente))
                return true; // cliente encontrado
        }
        return false;
    }
}