FROM eclipse-temurin:21-jdk as build

WORKDIR /configserver

COPY . /configserver/

RUN ./mvnw clean package -DskipTests

# Multi stage build
FROM openjdk:21-jdk

WORKDIR /configserver

EXPOSE 8888

COPY --from=build /configserver/target/configserver-0.0.1-SNAPSHOT.jar configserver.jar

CMD ["java", "-jar", "configserver.jar"]
