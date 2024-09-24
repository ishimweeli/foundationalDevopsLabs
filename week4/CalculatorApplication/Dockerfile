# Build stage
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean package -DskipTests

# Debugging - Check if the jar file is present
RUN ls -la /app/target

# Run stage
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/CalculatorApplication-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=1000
ENV JAVA_OPTS=""

EXPOSE ${PORT}

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar app.jar"]
