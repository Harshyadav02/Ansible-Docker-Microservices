FROM maven:3.9.2-eclipse-temurin-17-alpine as build
WORKDIR /userservice
COPY . /userservice/
RUN ./mvnw clean package -DskipTests


FROM openjdk:21
WORKDIR /userservice
COPY --from=build /userservice/target/userservice-0.0.1-SNAPSHOT.jar userservice.jar
EXPOSE 8083
CMD [ "java" ,"-jar" , "userservice.jar"]
