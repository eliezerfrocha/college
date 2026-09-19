class ContaCorrentePremium extends ContaCorrente {
    private double cashBackPercentual;

    public ContaCorrentePremium(String titular, double saldo, double limiteChequeEspecial, double cashBackPercentual) {
        super(titular, saldo, limiteChequeEspecial);
        this.cashBackPercentual = cashBackPercentual;
    }

    @Override
    public boolean sacar(double valor) {
        if (super.sacar(valor)) {
            double cashBack = valor * (cashBackPercentual / 100);
            depositar(cashBack);
            return true;
        }
        return false;
    }

    public String exibeBeneficioPremium() {
        return "\n > Conta Corrente Premium com cashback de " + cashBackPercentual + "% em cada saque.";
    }
}
