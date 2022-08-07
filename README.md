# Banco Digital

Um programa Java que simula um banco digital e suas principais funcionalidades. Desafio de projeto para **Santander Bootcamp Fullstack Developer** na [Digital Innovation One](https://www.dio.me).

## Funcionalidades
- :chart: Criação de conta.
- :chart: Saldo, depósito e saque.
- :chart: Transferências entre contas do mesmo usuário.

## Documentação
- [Instalação](#Instalação)
- [Métodos](#Endpoints)
- [Tecnologias](#Métodos)

## Instalação
Faça a instalação de uma das IDEs [Eclipse](https://www.eclipse.org/downloads/) ou [IntelliJ](https://www.jetbrains.com/pt-br/idea/).

Clone o repositório executando os comandos:
```bash
# Clone este repositório
$ git clone https://github.com/devsent/digital-bank/

# Acesse a pasta do projeto no seu terminal preferido
$ cd digital-bank
```
Abra a pasta em sua IDE preferida e inicie o programa.

## Métodos
 - **createAccount()**
> Recebe um *Customer* como parâmetro e cria uma nova conta usando suas propriedades.

 - **accountOptions()**
> Recebe uma string *holderName* como parâmetro e retorna um int com a opção selecionada pelo usuário.

 - **showAccountDetails()**
> Recebe *Account* como parâmetro e retorna os detalhes das contas.

 - **printAccountStatement()**
> Retorna strings formatadas com o extrato da conta em que o método é chamado.

 - **operations()**
> Recebe a operação em formato string *"deposit", "transfer" ou "withdraw"* e as contas *Account* envolvidas como parâmetro.

 - **deposit()**
> Recebe a quantia a se depositar em formato double e adiciona o total ao saldo de *Account*.

 - **transfer()**
> Recebe a quantia a enviar em formato double e a conta destino, chama *withdraw()* removendo a quantia da conta atual, e em seguida chama *deposit()* enviando a quantia para a conta destino.

 - **withdraw()**
> Recebe a quantia a sacar em formato double e remove o total ao saldo de *Account*.

## Tecnologias
Ferramentas utilizadas durante o desenvolvimento:

- [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/)
- [Java JDK 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
