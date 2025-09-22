# Use official OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy all project files into container
COPY . .

# Build the project using Maven wrapper, skip tests for faster build
RUN ./mvnw clean package -DskipTests

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Run the Spring Boot JAR
CMD ["java", "-jar", "target/test_api-0.0.1-SNAPSHOT.jar"]
