FROM maven:3.8.3-openjdk-17-slim AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar /app/my-app.jar

EXPOSE 8081

CMD ["java", "-jar", "my-app.jar"]
