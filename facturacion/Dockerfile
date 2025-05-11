# Dockerfile
FROM openjdk:21-ea-24-oracle

WORKDIR /app
#jar
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
#ubicacion y nombre del wallet
COPY Wallet_MHS8CE7TYHMKHXCM/ /app/oracle_wallet/
EXPOSE 8080

CMD ["java","-jar","app.jar"]