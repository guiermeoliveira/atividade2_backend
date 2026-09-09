public class desenvolvedor extends funcionario {

    public desenvolvedor(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }

    @Override
    public double calcularBonificacao() {
        return getSalario() * 0.10;
    }
}