
FROM maven:3.9.3-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
WORKDIR /app/fitnessapp
RUN mvn clean install -DskipTests


FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/fitnessapp/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
