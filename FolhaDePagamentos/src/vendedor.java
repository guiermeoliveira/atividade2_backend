public class vendedor extends funcionario {
    private double totalVendidoMes;

    public vendedor(String nome, String cpf, double salario, double totalVendidoMes) {
        super(nome, cpf, salario);
        setTotalVendidoMes(totalVendidoMes);
    }

    public double getTotalVendidoMes() {
        return totalVendidoMes;
    }

    public void setTotalVendidoMes(double totalVendidoMes) {
        if (totalVendidoMes < 0) {
            throw new IllegalArgumentException("O total vendido não pode ser negativo.");
        }
        this.totalVendidoMes = totalVendidoMes;
    }

    public double calcularComissao() {
        return this.totalVendidoMes * 0.02;
    }

    @Override
    public double calcularBonificacao() {
        double bonificacaoBase = getSalario() * 0.05;
        return bonificacaoBase + calcularComissao();
    }
}