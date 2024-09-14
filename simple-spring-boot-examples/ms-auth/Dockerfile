# Use an image with OpenJDK 17 and Gradle installed
FROM gradle:7.6.1-jdk17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy only the Gradle wrapper and build files to the image
COPY build.gradle.kts settings.gradle.kts gradlew gradlew.bat /app/

# Copy the rest of the project files
COPY . /app

# Run the Gradle build to create the JAR file
RUN ./gradlew build

# Second stage to build the final image
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/build/libs/ms-auth.jar ms-auth.jar

# Expose the application port
EXPOSE 8085

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "ms-auth.jar"]