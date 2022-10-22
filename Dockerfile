FROM openjdk:11-jdk-slim
WORKDIR /desafio-iti-kube
COPY /target/desafioiti-1.0.0.jar .
EXPOSE 8080
CMD ["java", "-jar", "desafioiti-1.0.0.jar", "server"]