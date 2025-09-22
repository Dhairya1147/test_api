FROM openjdk:21-jdk-slim
WORKDIR /app

# Copy all files
COPY . .

# Make mvnw executable
RUN chmod +x ./mvnw

# Build the project using Maven wrapper
RUN ./mvnw clean package -DskipTests

# Expose port 8080
EXPOSE 8080

# Run the Spring Boot JAR
CMD ["sh", "-c", "java -jar target/*.jar"]
