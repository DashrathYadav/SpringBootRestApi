The error message "mvn: not found" indicates that the `mvn` command (Maven) is not available in your Docker image. To resolve this issue, you need to ensure that Maven is installed in your Docker image so you can run Maven commands like `mvn dependency:go-offline` during the image build process.

You can do this by adding a step to install Maven in your Dockerfile. Here's an updated Dockerfile that installs Maven:

```Dockerfile
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

# Copy the JAR file from the target directory to the container
COPY target/*.jar app.jar

# Define the entry point for the container
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expose the port your application listens on
EXPOSE 8080
```

In this updated Dockerfile, the line `RUN apk add --no-cache maven` installs Maven in your Alpine-based Docker image. After that, you can use Maven commands without any issues.

Once you've updated your Dockerfile, rebuild your Docker image using the `docker build` command, and you should no longer encounter the "mvn: not found" error.