## Descrição

Este projeto é um exemplo de como usar RestAssured com JUnit em um projeto Maven para testar serviços REST.

## Pré-requisitos

Antes de começar, certifique-se de ter o seguinte instalado:

- [Java Development Kit (JDK)](https://www.oracle.com/br/java/technologies/downloads/)
- [Apache Maven](https://maven.apache.org/download.cgi)

## Configuração

1. Clone o repositório (ou faça o download do código-fonte):

  - git clone  https://github.com/raialmeida/Tests-API-RESTassured

## Uso

1. Navegue até o diretório do projeto:

```
/API-RestAssured
```
3. Para instalar no repositório local, utilize o seguinte comando:

```
mvn install
```
2. Para executar os testes, utilize o seguinte comando:

```
mvn test
```

3. Para executar o Allure Report, utilize o seguinte comando:

```
mvn allure:serve
```

_Obs:. Poderá executar os testes via JUnit conforme sua IDE_
## Estrutura do Projeto

- `src/test/java`: Código-fonte dos testes.
- `pom.xml`: Arquivo de configuração do Maven.
-  `target`: Pasta que vão armazenar reports do testes.

## Contribuição

Se desejar contribuir com o projeto, siga estas etapas:

1. Faça um fork do projeto.
2. Crie uma nova branch para suas alterações: `git checkout -b feature/nova-feature`.
3. Faça suas alterações e commit: `git commit -m 'Adiciona nova feature'`.
4. Envie suas alterações: `git push origin feature/nova-feature`.
5. Crie um Pull Request no repositório original.
