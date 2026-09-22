# Sistema de Biblioteca

## Tecnologias

Java 21 · Spring Boot · Spring Data JPA · PostgreSQL · Maven

## Estrutura

```
models/         entidades JPA (Book, Author, Category, User, Loan, LoanItem)
enums/          LoanStatus (ATIVO, DEVOLVIDO, ATRASADO)
repositories/   um repository por entidade, com as queries do desafio
dtos/           CategoryCountDto (projeção usada na consulta de agregação)
```

## Relacionamentos

- **Livro ↔ Autor** — muitos-para-muitos, via tabela associativa `tb_livro_autor`
- **Livro → Categoria** — muitos-para-um
- **Empréstimo → Usuário** — muitos-para-um
- **Empréstimo ↔ Livro** — via `LoanItem`, que guarda cada livro emprestado

## Consultas implementadas

1. Livros disponíveis, ordenados por título
2. Livros por categoria
3. Usuários por nome (busca parcial)
4. Empréstimos ativos de um usuário
5. Livros de um autor, ordenados por ano
6. Empréstimos atrasados
7. Quantidade de livros por categoria
