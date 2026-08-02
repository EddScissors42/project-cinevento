# Projeto Cinevento
Um projeto OO de Java, para final da Disciplina POO 2026.1

Um mini-sistema de Cinema com seleção de filmes, gerenciamento de ingressos e salvamento desses dados!

## Funcionalidades:
- Cadastro, Pesquisa, Listagem e Exclusão de Filmes
- Cadastro, Pesquisa, Listagem e Exclusão de Clientes
- Compra e Cancelamento de Ingressos
- Cadastro, Pesquisa, Listagem e Exclusão de Sessões

## Estrutura do projeto:
```text
src/cinevento/
├── irl [entidades (get/set)]
│   ├── Filme.java
│   ├── Cliente.java
│   ├── Cadeira.java
│   ├── Ingresso.java
│   └── Sessao.java
├── repository
│   ├── Cinema.java [Interface do sistema / Façade!]
│   └── TipoSala.java [Enum]
├── service
│   ├── CinemaService.java [implementação de tudo]
│   ├── SessaoInexistenteException.java
│   └── GravadorDeDados.java [persistência - fazendo!]
├── ui
│   └── TelaInicial.java [JFrame - a fazer]
└── Main.java

test/cinevento/
└── CinemaServiceTest.java [Testes JUnit - a fazer]

Tecnologias usadas :D
├── Java 25
├── Maven
├── Swing (JFrame, JMenuBar)
└── JUnit
```

Desenvolvido por
Cauê Soares (@cauesoares-beep), Maria Eduarda (@mariachagaas), Reydner Barros (@EddScissors42)
