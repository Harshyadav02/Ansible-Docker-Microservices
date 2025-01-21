FROM maven:3.9.2-eclipse-temurin-17-alpine as build

WORKDIR /gatway

COPY . /gatway/

RUN ./mvnw clean package -DskipTests

# Multi stage build
FROM openjdk:21

WORKDIR /gatway

EXPOSE 8080

COPY --from=build /gatway/target/gatway-0.0.1-SNAPSHOT.jar.jar gatway.jar

CMD [ "java", "-jar" , "gatway.jar" ]