public class ContaEmpresarial extends ContaBancaria {
    private static final double TAXA_SAQUE = 5.00;
    private double limiteCredito;

    public ContaEmpresarial(String numeroConta, String titular, double limiteCredito) {
        super(numeroConta, titular);
        this.limiteCredito = Math.max(limiteCredito, 0.0);
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public double getLimiteDisponivel() {
        if (getSaldo() < 0) {
            return limiteCredito + getSaldo();
        }
        return limiteCredito;
    }

    @Override
    public boolean sacar(double valor) {
        IO.println(String.format("Tentativa de saque: R$ %.2f%n", valor));

        if (valor <= 0) {
            IO.println("Erro no saque: O valor do saque deve ser maior que zero.");
            return false;
        }

        double custoTotal = valor + TAXA_SAQUE;
        double saldoDisponivelTotal = getSaldo() + limiteCredito;

        // Regra 6 e 7: Valida se o saldo + limite cobrem o saque E a taxa
        if (custoTotal > saldoDisponivelTotal) {
            IO.println(String.format("Saque recusado! Saldo + Limite insuficientes para saque de R$ %.2f com taxa de R$ %.2f (Total: R$ %.2f).%n", valor, TAXA_SAQUE, custoTotal));
            return false;
        }

        IO.println(String.format("Taxa de saque: R$ %.2f%n", TAXA_SAQUE));
        debitar(custoTotal); // Debita o saque + a taxa
        IO.println("Saque realizado com sucesso.");
        return true;
    }

    @Override
    public void exibirExtrato() {
        IO.println("-------------------------------------------");
        IO.println("Conta: " + getNumeroConta());
        IO.println("Titular: " + getTitular());
        IO.println(String.format("Saldo atual: R$ %.2f%n", getSaldo()));
        IO.println(String.format("Limite disponível: R$ %.2f%n", getLimiteDisponivel()));
        IO.println("-------------------------------------------");
    }
}