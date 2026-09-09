public abstract class funcionario {
    private String nome;
    private String cpf;
    private double salario;

    public funcionario(String nome, String cpf, double salario) {
        setNome(nome);
        setCpf(cpf);
        setSalario(salario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do funcionário não pode ser vazio.");
        }
        this.nome = nome.trim();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("O CPF não pode ser vazio.");
        }
        this.cpf = cpf.trim();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException("O salário deve ser maior que zero.");
        }
        this.salario = salario;
    }

    public abstract double calcularBonificacao();

    public double calcularRemuneracaoTotal() {
        return this.salario + calcularBonificacao();
    }

    public void exibirHolerite() {
        IO.println("Funcionário: " + this.nome);
        IO.println("CPF: " + this.cpf);
        IO.println("Cargo: " + this.getClass().getSimpleName());
        IO.println(String.format("Salário: R$ %.2f", this.salario));
        IO.println(String.format("Bonificação: R$ %.2f", calcularBonificacao()));
        IO.println(String.format("Remuneração total: R$ %.2f", calcularRemuneracaoTotal()));
        IO.println("----------------------------------------");
    }
}