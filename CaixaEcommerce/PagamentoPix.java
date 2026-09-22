// CONCEITO: HERANÇA ('extends')
// PagamentoPix herda todos os atributos e métodos não-privados de FormaPagamento (reuso de código).
public class PagamentoPix extends FormaPagamento {

    // Atributo específico desta subclasse (Encapsulado)
    private String chavePix;

    public PagamentoPix(String titular, String chavePix) {
        // 'super' chama o construtor da superclasse FormaPagamento
        super(titular);
        this.chavePix = chavePix;
    }

    public String getChavePix() {
        return chavePix;
    }

    // CONCEITO: POLIMORFISMO (Sobrescrita / @Override)
    // A classe filha dá o comportamento específico para a ação abstrata definida no pai.
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando PIX de R$ " + valor + " para o titular " + getTitular() + " (Chave: " + chavePix + ")");
    }
}