public class ContaCorrente extends ContaBancaria {

    protected double limiteChequeEspecial;

    // Construtor
    public ContaCorrente(String titular, double saldo) {
        super(titular, saldo);
        calcularLimiteChequeEspecial(); // Calcula o limite no momento da criação da conta
    }

    public ContaCorrente(String titular, double saldo, double limiteChequeEspecial2) {
        super(titular, saldo);
        this.limiteChequeEspecial = limiteChequeEspecial2; // Define o limite de cheque especial
        calcularLimiteChequeEspecial(); // Calcula o limite no momento da criação da conta
    }

    // Método para calcular o limite de cheque especial com base no saldo atual
    private void calcularLimiteChequeEspecial() {
        this.limiteChequeEspecial = getSaldo() * 0.5; // 50% do saldo como limite
    }

    // Getter para o limiteChequeEspecial
    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    // Método sobrescrito para sacar dinheiro
    @Override
    public boolean sacar(double valor) {
        if (getSaldo() + limiteChequeEspecial >= valor) {
            setSaldo(getSaldo() - valor); // Realiza o saque
            calcularLimiteChequeEspecial(); // Recalcula o limite após o saque
            return true;
        }
        return false;
    }

    // Método para depositar dinheiro
    @Override
    public void depositar(double valor) {
        setSaldo(getSaldo() + valor); // Realiza o depósito
        calcularLimiteChequeEspecial(); // Recalcula o limite após o depósito
    }

    @Override
    public String exibeSaldo() {
        return String.format("\n > Saldo da conta de %s: R$ %.2f", getTitular(), getSaldo());
    }
}