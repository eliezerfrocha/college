class ContaCorrenteEmpresarial extends ContaCorrente {
    protected double taxaJurosEmprestimo;

    public ContaCorrenteEmpresarial(String titular, double saldo, double limiteChequeEspecial, double taxaJurosEmprestimo) {
        super(titular, saldo, limiteChequeEspecial);
        this.taxaJurosEmprestimo = taxaJurosEmprestimo;
    }

    public boolean solicitaEmprestimo(double valor) {
        if (valor <= saldo + limiteChequeEspecial) {
            saldo += valor;
            return true;
        }
        return false;
    }

    @Override
    public String exibeSaldo() {
        return "\n > Saldo da conta empresarial de " + titular + ": R$ " + String.format("%.2f", saldo);
    }
}
