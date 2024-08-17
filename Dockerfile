FROM openjdk:22-jdk

WORKDIR /app

COPY target/api-vendedores-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]