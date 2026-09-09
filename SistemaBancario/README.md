\# Sistema Bancário - Banco Digital Fácil



Projeto desenvolvido para a disciplina de Programação Orientada a Objetos com foco na construção de uma estrutura segura para movimentação de contas, eliminando riscos de alterações indevidas de saldo.



\## Diferenças Entre os Três Tipos de Conta



\- \*\*Conta Poupança:\*\* não possui limite de crédito emergencial. Operações que excedam o saldo disponível são recusadas, impedindo saldo negativo.

\- \*\*Conta Corrente:\*\* disponibiliza um limite emergencial. O cliente pode utilizar esse valor além do saldo positivo, admitindo saldo negativo dentro da margem autorizada.

\- \*\*Conta Empresarial:\*\* projetada para clientes corporativos com limites maiores. Aplica uma tarifa fixa de R$ 5,00 debitada a cada saque realizado.



\## Regras de Operação



\- \*\*Depósito:\*\* aceita apenas valores estritamente maiores do que zero. Valores zerados ou negativos são bloqueados.

\- \*\*Saque:\*\* cada modalidade valida a disponibilidade de fundos antes de efetuar o débito. Saques com valores menores ou iguais a zero são recusados.



\## Decisões Técnicas de Segurança e Encapsulamento



\- \*\*Ausência de `setSaldo()`:\*\* a regra de negócio exige que o saldo nunca seja alterado arbitrariamente por classes externas ou pela classe principal. O valor só pode ser modificado através de depósitos e saques validados.

\- \*\*Uso do método `protected debitar()`:\*\* como o atributo `saldo` é privado para impedir acesso externo direto, o método `debitar()` com visibilidade `protected` permite que apenas as classes derivadas autorizadas alterem o valor após executarem suas regras específicas de taxas e limites.



\## Estrutura do Projeto



```text

src/

├── ContaBancaria.java

├── ContaCorrente.java

├── ContaPoupanca.java

├── ContaEmpresarial.java

└── Main.java

