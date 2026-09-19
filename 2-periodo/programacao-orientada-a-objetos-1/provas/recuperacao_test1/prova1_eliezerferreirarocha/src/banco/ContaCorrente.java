package banco;

public class ContaCorrente {
    private String nome;
    private String nomeConta;
    private double saldo;
    private double limite;
    private static int contas = 0;

    // construtor para conta comum (limite = 0)
    public ContaCorrente(String nome, String nomeConta, double saldo) {
        this.nome = nome;
        this.nomeConta = nomeConta;
        this.saldo = saldo;
        this.limite = 0;
        contas++;
    }

    // construtor para conta especial (com limite definido)
    public ContaCorrente(String nome, String nomeConta, double saldo, double limite) {
        this.nome = nome;
        this.nomeConta = nomeConta;
        this.saldo = saldo;
        this.limite = limite;
        contas++;
    }

    public static int getTotalContas() {
        return contas;
    }

    public boolean sacar(double valor) {
        if (valor > 0) {
            if (limite == 0) { // conta comum
                if (saldo >= valor) { // verifica se o saldo é suficiente
                    saldo -= valor;
                    return true;
                }
            } else { // conta especial
                if (saldo >= valor) { // se o saldo for suficiente
                    saldo -= valor;
                    return true;
                } else if (saldo > 0) { // se houver saldo, verifica o limite
                    if (valor - saldo <= limite) {
                        saldo -= valor;
                        return true;
                    }
                } else if (limite + saldo >= valor) { // verifica se o limite cobre a diferença
                    saldo -= valor;
                    return true;
                }
            }
        }
        return false;
    }

    public void depositar(double valor) {
        if (valor > 0) { // só permite depósitos positivos
            saldo += valor;
        }
    }

    public String exibe() {
        String tipoConta = (limite == 0) ? "Comum" : "Especial";
        String dados = 
                "Nome: " + nome + "\n" +
                "Número da Conta: " + nomeConta + "\n" +
                "Tipo de Conta: " + tipoConta + "\n" +
                "Saldo: R$" + String.format("%.2f", saldo) + "\n" +
                "Limite: R$" + String.format("%.2f", limite) + "\n" +
                "Quantidade de contas abertas: " + getTotalContas(); // formata os dados da conta

        return dados;
    }    
}