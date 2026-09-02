import java.util.concurrent.ThreadLocalRandom;

public class Main {

    // Gera um numero de conta aleatorio
    private static String gerarNumeroConta() {
        int numero = ThreadLocalRandom.current().nextInt(1, 10000);
        int digito = ThreadLocalRandom.current().nextInt(0, 10);
        return String.format("%04d-%d", numero, digito);
    }

    public static void main() {

        IO.println("==============================================");
        IO.println("   BEM-VINDO AO BANCO DIGITAL FÁCIL");
        IO.println("==============================================");

        // 1. Cliente insere o nome
        String titular = IO.readln("Informe o nome do titular: ");

        // 2. Gerar número de conta aleatório
        String numeroConta = gerarNumeroConta();
        IO.println("\n[SISTEMA] Conta gerada com sucesso: " + numeroConta);

        // 3. Escolha do tipo de conta
        IO.println("\nSelecione o tipo de conta:");
        IO.println("1 - Conta Poupança (sem limite)");
        IO.println("2 - Conta Corrente (limite padrão R$ 500,00)");
        IO.println("3 - Conta Empresarial (limite padrão R$ 5.000,00)");
        int opcao = Integer.parseInt(IO.readln("Opção: "));

        ContaBancaria conta;

        switch (opcao) {
            case 1:
                conta = new ContaPoupanca(numeroConta, titular);
                break;
            case 2:
                conta = new ContaCorrente(numeroConta, titular, 500.00);
                break;
            case 3:
                conta = new ContaEmpresarial(numeroConta, titular, 5000.00);
                break;
            default:
                IO.println("Opção inválida! Criando Conta Poupança por padrão.");
                conta = new ContaPoupanca(numeroConta, titular);
                break;
        }

        IO.println("\n>>> CONTA ABERTA COM SUCESSO <<<");
        conta.exibirExtrato();

        // 4. Teste inicial de movimentação
        double primeiroDeposito = Double.parseDouble(IO.readln("Informe um valor para o primeiro depósito: R$ "));
        conta.depositar(primeiroDeposito);

        double valorSaque = Double.parseDouble(IO.readln("\nInforme um valor para teste de saque: R$ "));
        conta.sacar(valorSaque);

        IO.readln("\n>>> EXTRATO FINAL <<<");
        conta.exibirExtrato();

    }
}