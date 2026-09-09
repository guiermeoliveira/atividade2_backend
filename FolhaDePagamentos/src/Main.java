import java.util.ArrayList;
import java.util.List;

void main(String[] args) {
        IO.println("=== TESTES DE VALIDAÇÕES INVÁLIDAS ===\n");

        // 1. Tentativa de nome vazio
        try {
            IO.println("Testando cadastro com nome vazio:");
            new gerente("", "111.222.333-44", 8000.0);
        } catch (IllegalArgumentException e) {
            IO.println("Erro capturado: " + e.getMessage());
        }

        // 2. Tentativa de CPF vazio
        try {
            IO.println("\nTestando cadastro com CPF vazio:");
            new desenvolvedor("Lucas Silva", "   ", 5000.0);
        } catch (IllegalArgumentException e) {
            IO.println("Erro capturado: " + e.getMessage());
        }

        // 3. Tentativa de salário zero ou negativo
        try {
            IO.println("\nTestando cadastro com salário zero:");
            new vendedor("Ana Paula", "222.333.444-55", 0.0, 10000.0);
        } catch (IllegalArgumentException e) {
            IO.println("Erro capturado: " + e.getMessage());
        }

        IO.println("\n========================================");
        IO.println("=== DEMONSTRAÇÃO DA FOLHA DE PAGAMENTO ===");
        IO.println("========================================\n");

        funcionario gerente = new gerente("Mariana Souza", "123.456.789-00", 10000.00);
        funcionario desenvolvedor = new desenvolvedor("Carlos Lima", "234.567.890-11", 7000.00);
        funcionario vendedor = new vendedor("Beatriz Santos", "345.678.901-22", 4000.00, 50000.00);

        List<funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(gerente);
        funcionarios.add(desenvolvedor);
        funcionarios.add(vendedor);

        double totalFolha = 0.0;

        for (funcionario funcionario : funcionarios) {
            funcionario.exibirHolerite();
            totalFolha += funcionario.calcularRemuneracaoTotal();
        }

        IO.println(String.format("Total da folha: R$ %.2f", totalFolha));
    }
