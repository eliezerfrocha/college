class ContaPoupamcaEstudantil extends ContaPoupanca {
    private double limiteIsencaoTaxa;

    public ContaPoupamcaEstudantil(String titular, double saldo, double taxaRendimento, double limiteIsencaoTaxa) {
        super(titular, saldo, taxaRendimento);
        this.limiteIsencaoTaxa = limiteIsencaoTaxa;
    }

    public String exibeLimiteIsencao() {
        return "\n > Limite de isenção de taxa para estudantes: R$ " + String.format("%.2f", limiteIsencaoTaxa);
    }
}
