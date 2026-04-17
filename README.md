## Descrição
[![Tests API CI](https://github.com/raialmeida/Tests-API-RestAssured/actions/workflows/api-test-ci.yml/badge.svg)](https://github.com/raialmeida/Tests-API-RestAssured/actions/workflows/api-test-ci.yml)

Este projeto é um exemplo de como usar RestAssured com JUnit em um projeto Maven para testar serviços REST.

Para visualizar o report allure [clique aqui](https://raialmeida.github.io/Tests-API-RestAssured/)

## Pré-requisitos

Antes de começar, certifique-se de ter o seguinte instalado:

- [Java Development Kit (JDK), versão 17 ou superior](https://www.oracle.com/br/java/technologies/downloads/)
- [Apache Maven](https://maven.apache.org/download.cgi)

## Configuração

1. Clone o repositório (ou faça o download do código-fonte):

  - git clone  https://github.com/raialmeida/Tests-API-RESTassured

## Uso


1. Para instalar no repositório local, utilize o seguinte comando:

```
mvn install
```
3. Para executar os testes, utilize o seguinte comando:

```
mvn test
```

4. Para executar o Allure Report, utilize o seguinte comando:

```
mvn allure:serve
```

5. Para executar os testes no container docker, utilize o seguinte comando:

```
docker-compose run --rm api-test mvn test
```
6. Para executar os testes de acordo com o ambiente, utilize o seguinte comando:

```
mvn test -P dev
```
7. Para executar os testes de acordo com a tag, utilize o seguinte comando:

```
mvn test -Dgroups=Smoke
```

_Obs:. Poderá executar os testes via JUnit conforme sua IDE_
## Estrutura do Projeto

    📦src
      ┗ 📂test
         ┣ 📂java
         ┃ ┣ 📂Config
         ┃ ┃  ┗📜TestConfig.java
         ┃ ┣ 📂Services
         ┃ ┃ ┣ 📂CadastroProdutos
         ┃ ┃ ┃ ┣ 📂payloads
         ┃ ┃ ┃ ┃  ┗📜CadastroProdutoPayloads.java
         ┃ ┃ ┃ ┣ 📂requests
         ┃ ┃ ┃ ┃  ┗📜CadastroProdutoRequests.java
         ┃ ┃ ┃ ┣ 📂schema
         ┃ ┃ ┃ ┃  ┗📜SchemaCadastroProduto.json
         ┃ ┃ ┃ ┗ 📂tests
         ┃ ┃ ┃ ┃  ┗📜CadastroProdutosTest.java
         ┃ ┃ ┣ 📂CadastroUsuarios
         ┃ ┃ ┃ ┣ 📂payloads
         ┃ ┃ ┃ ┃  ┗📜CadastroUsuarioPayloads.java
         ┃ ┃ ┃ ┣ 📂requests
         ┃ ┃ ┃ ┃  ┗📜CadastroUsuarioRequests.java
         ┃ ┃ ┃ ┗ 📂tests
         ┃ ┃ ┃ ┃  ┗📜CadastroUsuarioTest.java
         ┃ ┗ 📂Utils
         ┃ ┃  ┣📜Environment.java
         ┃ ┃  ┣📜SchemaValidator.java
         ┃ ┃  ┗📜UtilsUsuario.java
         ┗ 📂resources
            ┣📜dev.properties
            ┣📜hml.properties
            ┗📜prd.propertie

 
- `src/test/java/Config`: Código com as configurações dos testes.
- `src/test/java/Services`: Pasta que contém os serviços separado por pasta e cada serviços tem suas pastas separada por atribuição.
- `src/test/java/Utils`: Contém arquivo de configuração de variveis de ambiente e utilitários dos testes. 
- `pom.xml`: Arquivo de configuração do Maven.
- `target`: Pasta criada na execução que vão armazenar reports do testes.

## Contribuição

Se desejar contribuir com o projeto, siga estas etapas:

1. Faça um fork do projeto.
2. Crie uma nova branch para suas alterações: `git checkout -b feature/nova-feature`.
3. Faça suas alterações e commit: `git commit -m 'Adiciona nova feature'`.
4. Envie suas alterações: `git push origin feature/nova-feature`.
5. Crie um Pull Request no repositório original.
