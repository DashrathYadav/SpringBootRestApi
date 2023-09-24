FROM eclipse-temurin:20-jdk-alpine

# Install Maven
RUN apk add --no-cache maven

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



# Define the entry point for the container
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expose the port your application listens on
EXPOSE 8080