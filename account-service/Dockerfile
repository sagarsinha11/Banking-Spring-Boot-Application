# Using base image for java 17
FROM eclipse-temurin:17-jdk-alpine

# Defines the author of the file
LABEL authors="sagar"

# Set working directory inside the container
WORKDIR /app

# Copy the jar file
COPY target/account-service-0.0.1-SNAPSHOT.jar app.jar

# Exposing the service port
EXPOSE 8082

# Run the jar file during the runtime of the container
ENTRYPOINT ["java", "-jar", "app.jar"]