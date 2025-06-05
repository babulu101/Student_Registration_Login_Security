# Use a lightweight OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the packaged jar file into the container
COPY target/*.jar app.jar

# Expose port 8080 (or your app’s port)
EXPOSE 3737

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
