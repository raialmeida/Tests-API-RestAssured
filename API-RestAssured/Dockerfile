# Use uma imagem base do Maven com Java
FROM maven:3.8.7-openjdk-18-slim

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo pom.xml para o contêiner
COPY pom.xml .

# Copie o código de teste para o contêiner
COPY src src

# Execute o comando Maven para compilar e executar os testes
RUN mvn test