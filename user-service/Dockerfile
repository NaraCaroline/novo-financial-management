FROM maven:3.8.4-openjdk-17-slim AS build
LABEL authors="Nara"

WORKDIR /app

COPY pom.xml .

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk

COPY target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]