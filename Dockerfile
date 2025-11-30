# Step 1: Build Stage (Using Java 21 + Maven)
FROM maven:3.9.7-eclipse-temurin-21 AS build
WORKDIR /app

# Copy pom.xml and download dependencies first
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and package the application
COPY src ./src
RUN mvn clean package -DskipTests

# Step 2: Run Stage (Java 21)
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy the packaged jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose application port
EXPOSE 8085

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
