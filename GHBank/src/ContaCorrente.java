public class ContaCorrente extends ContaBancaria {
    private double limite;

public ContaCorrente(String numeroConta, String titular, double limite) {
    super(numeroConta, titular);
    this.limite = Math.max(limite, 0.0);
}

public double getLimite() {
    return limite;
}

// Limite disponível considera o quanto do limite já foi consumido se o saldo estiver negativo
public double getLimiteDisponivel() {
    if (getSaldo() < 0) {
        return limite + getSaldo(); // Ex: 1000 + (-200) = 800
    }
    return limite;
}

@Override
public boolean sacar(double valor) {
    IO.println(String.format("Tentativa de saque (Corrente): R$ %.2f%n", valor));

    if (valor <= 0) {
        IO.println("Erro no saque: O valor deve ser maior que zero.");
        return false;
    }

    // Regra 5: Pode sacar até o saldo + limite total
    double saldoDisponivelTotal = getSaldo() + limite;
    if (valor > saldoDisponivelTotal) {
        IO.println(String.format("Saque recusado! Valor excede o saldo somado ao limite (Disponível total: R$ %.2f).%n", saldoDisponivelTotal));
        return false;
    }

    debitar(valor);
    IO.println("Saque realizado com sucesso.");
    return true;
}

@Override
public void exibirExtrato() {
    super.exibirExtrato();
    IO.println(String.format("Limite Total: R$ %.2f | Limite Disponível: R$ %.2f%n", limite, getLimiteDisponivel()));
    IO.println("-------------------------------------------");
}
}