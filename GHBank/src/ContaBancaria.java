public abstract class ContaBancaria{
        private String titular;
        private String numeroConta;
        private double saldo;

        public ContaBancaria (String numeroConta, String titular){
            this.titular = titular;
            this.numeroConta = numeroConta;
            this.saldo = 0.0;
        }
        public boolean depositar (double valor) {
            if(valor <= 0){
                IO.println("Erro: O valor do depósito deve ser maior que zero.");
                return false;
            }
            this.saldo += valor;
            IO.println(String.format("Depósito de R$ %.2f realizado. Saldo atual: R$ %.2f%n", valor, this.saldo));
            return true;
        }

        protected void debitar(double valor) {
            this.saldo -= valor;
        }

        // Leitura segura do saldo (sem permitir alteração direta)
        public double getSaldo() {
            return this.saldo;
        }

        public String getNumeroConta() {
            return numeroConta;
        }

        public String getTitular() {
            return titular;
        }

        // Contrato polimórfico: cada conta define como valida e executa o saque
        public abstract boolean sacar(double valor);

        // Extrato básico
        public void exibirExtrato() {
            IO.println("-------------------------------------------");
            IO.println("Conta: " + numeroConta);
            IO.println("Titular: " + titular);
            IO.println(String.format("Saldo atual: R$ %.2f%n", saldo));
            IO.println("-------------------------------------------");
        }

}
