// CONCEITO: HERANÇA ('extends')
public class PagamentoCartao extends FormaPagamento {

    private String numeroCartao;
    private int parcelas;

    public PagamentoCartao(String titular, String numeroCartao, int parcelas) {
        super(titular);
        this.numeroCartao = numeroCartao;
        this.parcelas = parcelas;
    }

    // CONCEITO: POLIMORFISMO (Sobrescrita / @Override)
    // O mesmo método 'processarPagamento' se comporta de forma totalmente diferente do Pix.
    @Override
    public void processarPagamento(double valor) {
        double valorParcela = valor / parcelas;
        System.out.println("Processando Cartão final " + numeroCartao.substring(numeroCartao.length() - 4)
                + " | Titular: " + getTitular()
                + " | " + parcelas + "x de R$ " + valorParcela);
    }
}