FROM eclipse-temurin:20-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the project's POM file
COPY pom.xml .

# Download the Maven dependencies
RUN mvn dependency:go-offline

# Copy the application source code
COPY src/ src/

# Build the application
RUN mvn clean package

# Copy the JAR file from the target directory to the container
COPY target/*.jar app.jar

# Define the entry point for the container
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expose the port your application listens on
EXPOSE 8080
