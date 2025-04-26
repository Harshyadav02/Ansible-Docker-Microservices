FROM eclipse-temurin:21-jdk as build
WORKDIR /orderservice
COPY . /orderservice/
RUN ./mvnw clean package -DskipTests


FROM openjdk:21

WORKDIR /orderservice

COPY --from=build /orderservice/target/orderservice-0.0.1-SNAPSHOT.jar orderservice.jar

EXPOSE 8082

CMD [ "java" ,"-jar" , "orderservice.jar"]
