# Sistema de Folha de Pagamento - TechSolutions



Este projeto foi desenvolvido como atividade prática da disciplina de Programação Orientada a Objetos. O objetivo é substituir o cálculo manual de bonificações por uma solução modular em Java, permitindo que a empresa cadastre novos cargos futuramente sem reescrever a base do sistema.



## Objetivo do Sistema



Calcular a remuneração final dos funcionários com base nas regras de cada cargo, acumulando os valores para obter o custo total da folha de pagamento da empresa.



## Regras de Negócio e Bonificações



- **Gerente:** recebe bonificação correspondente a 20% do salário-base.

- **Desenvolvedor:** recebe bonificação correspondente a 10% do salário-base.

- **Vendedor:** recebe 5% do salário-base somado a uma comissão calculada sobre as vendas do mês (2% sobre o total vendido).

- **Cálculo da Remuneração Total:** Salário Base + Bonificação.

- **Validações:** o sistema impede o cadastro de funcionários com nome vazio, CPF em branco ou salário menor ou igual a zero. Vendas negativas também são rejeitadas.



## Conceitos de Orientação a Objetos Aplicados



- **Abstração:** a classe `Funcionario` foi definida como abstrata, reunindo atributos e métodos universais para qualquer funcionário. Ela não pode ser instanciada diretamente. O método `calcularBonificacao()` é abstrato, exigindo que cada subclasse determine seu próprio cálculo.

- **Herança:** as classes `Gerente`, `Desenvolvedor` e `Vendedor` utilizam `extends Funcionario` para herdar o construtor, os atributos básicos e a lógica de exibição do holerite.

- **Encapsulamento:** todos os atributos são `private`. O acesso e as alterações são intermediados por métodos `get` e `set`, com verificações que impedem inconsistências de dados.

- **Polimorfismo:** a classe `Main` manipula uma coleção do tipo genérico `List<Funcionario>`, chamando `calcularRemuneracaoTotal()` e `exibirHolerite()` de forma uniforme, enquanto cada subclasse executa sua própria fórmula em tempo de execução.



## Estrutura do Projeto



```text

src/

├── Funcionario.java

├── Gerente.java

├── Desenvolvedor.java

├── Vendedor.java

└── Main.java

