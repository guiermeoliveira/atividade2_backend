public class Main {
    public static void main(String[] args) {
        Caixa caixa = new Caixa();

        // Criando instâncias polimórficas (tipo da variável é a superclasse)
        FormaPagamento pagamento1 = new PagamentoPix("Maria Silva", "maria@email.com");
        FormaPagamento pagamento2 = new PagamentoCartao("João Santos", "1234567890123456", 3);

        // O Caixa executa o método genérico, e o Java sabe qual comportamento rodar em tempo de execução
        caixa.finalizarVenda(150.00, pagamento1);
        caixa.finalizarVenda(600.00, pagamento2);
    }
}