FROM maven:3.9.2-eclipse-temurin-17-alpine as build
WORKDIR /orderservice
COPY . /orderservice/
RUN ./mvnw clean package -DskipTests


FROM openjdk:21

WORKDIR /orderservice

COPY --from=build /orderservice/target/orderservice-0.0.1-SNAPSHOT.jar orderservice.jar

EXPOSE 8082

CMD [ "java" ,"-jar" , "orderservice.jar"]
