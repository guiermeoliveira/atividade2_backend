public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(String numeroConta, String titular){
        super(numeroConta, titular);
    }

    @Override
    public boolean sacar(double valor){
        IO.println(String.format("Tentativa de saque (Poupança): R$ %.2f%n", valor));

        if (valor <= 0) {
            IO.println("Erro no saque: O valor solicitado deve ser maior que zero.");
            return false;
        }

        // Regra 4: Poupança não pode ficar negativa
        if (valor > getSaldo()) {
            IO.println(String.format("Saque recusado! Saldo insuficiente (Saldo atual: R$ %.2f).%n", getSaldo()));
            return false;
        }

        // Se passou pelas regras, aciona a porta controlada da mãe
        debitar(valor);
        IO.println("Saque realizado com sucesso.");
        return true;

    }
}
