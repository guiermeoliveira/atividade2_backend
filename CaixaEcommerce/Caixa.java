public class Caixa {

    // CONCEITO: AGREGAÇÃO / ASSOCIAÇÃO
    // O Caixa "tem um" método de pagamento para a transação atual.
    // O Caixa não herda de FormaPagamento; ele apenas se relaciona com ela.
    // Além disso, graças ao POLIMORFISMO, a referência aponta para o tipo genérico FormaPagamento,
    // permitindo aceitar PIX, Cartão ou qualquer outra forma criada no futuro sem alterar o Caixa.
    public void finalizarVenda(double total, FormaPagamento formaPagamento) {
        System.out.println("--- Finalizando Venda ---");
        formaPagamento.processarPagamento(total);
        System.out.println("Venda concluída com sucesso!\n");
    }
}