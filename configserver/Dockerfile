FROM maven:3.9.2-eclipse-temurin-17-alpine as build

WORKDIR /configserver

COPY . /configserver/

RUN ./mvnw clean package -DskipTests

# Multi stage build
FROM openjdk:21-jdk

WORKDIR /configserver

EXPOSE 8888

COPY --from=build /configserver/target/configserver-0.0.1-SNAPSHOT.jar configserver.jar

CMD ["java", "-jar", "configserver.jar"]
