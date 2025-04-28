# Using base image for java 17
FROM eclipse-temurin:17-jdk-alpine

# Defines the author of the file
LABEL authors="sagar"

# Set working directory inside the container
WORKDIR /app

# Copy the jar file
COPY target/eureka-server-0.0.1-SNAPSHOT.jar app.jar

# Exposing Eureka default port
EXPOSE 8761

# Run the jar file during the runtime of the container
ENTRYPOINT ["java", "-jar", "app.jar"]