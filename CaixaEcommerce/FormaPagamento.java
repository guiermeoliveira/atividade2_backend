// CONCEITO: ABSTRAÇÃO
// Uma classe abstrata serve como molde/contrato geral.
// Não pode ser instanciada diretamente (ex: new FormaPagamento() não existe),
// pois "forma de pagamento" é um conceito genérico no mundo real.
public abstract class FormaPagamento {

	// CONCEITO: ENCAPSULAMENTO
	// O atributo é 'private' para proteger os dados internos do objeto contra acesso direto e indevido.
	private String titular;

	public FormaPagamento(String titular) {
		this.titular = titular;
	}

	// CONCEITO: ENCAPSULAMENTO (Getters e Setters)
	// Permitem a leitura e manipulação controlada do estado do objeto.
	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	// CONCEITO: ABSTRAÇÃO & POLIMORFISMO
	// Método abstrato: define O QUE deve ser feito, mas não COMO.
	// Obriga cada classe filha a fornecer sua própria implementação.
	public abstract void processarPagamento(double valor);
}