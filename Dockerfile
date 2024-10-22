# Usando uma imagem base do OpenJDK
FROM openjdk:17-jdk

# Definindo o diretório de trabalho
WORKDIR /app

# Copiando o arquivo JAR da raiz do projeto para o contêiner
COPY ./rinha-de-backend-2023-q3.jar app.jar

# Expondo a porta
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]