# Stage 1: Build the application
FROM maven:3.8.4-openjdk-11-slim AS builder

# Set the working directory inside the container
WORKDIR /build

# Copy the project files to the container
COPY ./pom.xml ./pom.xml
COPY ./src ./src

# Package the application (without running tests)
RUN mvn clean package -DskipTests

# Stage 2: Create the final Docker image
FROM openjdk:11-jre-slim AS runtime

# Copy the built JAR from the previous stage
COPY --from=builder /build/target/itsm_backend-1.0-SNAPSHOT.jar /app/app.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
