# Projeto Cinevento
Um projeto OO de Java, para final da Disciplina POO 2026.1

Um mini-sistema de Cinema com seleção de filmes, gerenciamento de ingressos e salvamento desses dados!

## Funcionalidades:
- Cadastro, Pesquisa, Listagem e Exclusão de Filmes
- Cadastro, Pesquisa, Listagem e Exclusão de Clientes
- Compra sistemática de ingressos para clientes [Versão Lite]
- Apontamento do filme cadastrado para uma sessão do cinema

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
│   ├── CinemaService.java [implementação dos metodos]
│   ├── SessaoInexistenteException.java
│   └── GravadorDeDados.java [persistência de dados do sistema]
├── ui
│   ├── TelaAtendimentoClient.java [o ponto de venda intuitivo para clientes]
│   ├── TelaClientes.java
│   ├── TelaFilmes.java
│   ├── TelaIngressos.java
│   ├── TelaInicial.java
│   └── TelaSessoes.java
└── Main.java

test/cinevento/
└── CinemaServiceTest.java [Testes JUnit]

Tecnologias usadas :D
├── Java 25
├── Maven
├── Swing (JFrame, JMenuBar)
└── JUnit
```

Desenvolvido por
Cauê Soares (@cauesoares-beep), Maria Eduarda (@mariachagaas), Reydner Barros (@EddScissors42)
