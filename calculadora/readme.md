# 🧮 API de Calculadora — Spring Boot

API REST desenvolvida como atividade da disciplina **Desenvolvimento de Sistemas Corporativos**, do curso de **Análise e Desenvolvimento de Sistemas (ADS)** — IFRN.

O projeto implementa operações matemáticas utilizando **Spring Boot**, trabalhando com endpoints HTTP, parâmetros de requisição, estruturas condicionais e tratamento de situações inválidas.

## 🎯 Objetivo

Praticar os conceitos de:

* `@RestController`
* `@RequestMapping`
* `@GetMapping`
* `@PathVariable`
* `@RequestParam`
* Parâmetros opcionais com `defaultValue`
* Operadores matemáticos
* `if/else`
* `switch`
* Tratamento de divisão por zero

## 🚀 Tecnologias

* Java
* Spring Boot
* Spring Web
* Maven

## 📌 Endpoints

### Soma

```http
GET /calculadora/somar?numero1=10&numero2=5
```

Retorno:

```text
15
```

### Subtração

```http
GET /calculadora/subtrair?numero1=20&numero2=8
```

Retorno:

```text
12
```

### Cálculo

Endpoint único para realizar diferentes operações.

#### Somar

```http
GET /calculadora/calcular/somar?numero1=10&numero2=5
```

#### Subtrair

```http
GET /calculadora/calcular/subtrair?numero1=10&numero2=5
```

#### Multiplicar

```http
GET /calculadora/calcular/multiplicar?numero1=10&numero2=5
```

#### Dividir

```http
GET /calculadora/calcular/dividir?numero1=10&numero2=3
```

Por padrão, a divisão utiliza **2 casas decimais**.

Também é possível informar a quantidade de casas decimais:

```http
GET /calculadora/calcular/dividir?numero1=10&numero2=3&casasDecimais=4
```

Resultado:

```text
3.3333
```

A divisão por zero é tratada:

```http
GET /calculadora/calcular/dividir?numero1=10&numero2=0
```

Retorno:

```text
Erro: não é possível dividir por zero
```

### Par ou Ímpar

```http
GET /calculadora/par-ou-impar/10
```

Retorno:

```text
PAR
```

### Análise de número

```http
GET /calculadora/analisar/10
```

Retorno:

```text
Numero: 10
Par ou Impar: PAR
Positivo, negativo ou zero: POSITIVO
Dobro: 20
Metade: 5.0
Quadrado: 100.0
```

### Média

Recebe três notas e informa a situação do aluno.

```http
GET /calculadora/media?nota1=7&nota2=8&nota3=6
```

Retorno:

```text
Média: 7.0
Situação: APROVADO
```

As situações são definidas pelas seguintes regras:

| Média     | Situação    |
| --------- | ----------- |
| ≥ 7       | APROVADO    |
| ≥ 4 e < 7 | RECUPERAÇÃO |
| < 4       | REPROVADO   |



## ▶️ Como executar

Clone o repositório:

```bash
git clone URL_DO_REPOSITORIO
```

Entre na pasta do projeto:

```bash
cd nome-do-projeto
```

Execute a aplicação pelo Maven:

```bash
./mvnw spring-boot:run
```

A API estará disponível em:

```text
http://localhost:8080
```
