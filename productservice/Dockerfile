FROM eclipse-temurin:21-jdk as build
WORKDIR /productservice
COPY . /productservice/
RUN ./mvnw clean package -DskipTests


FROM openjdk:21
WORKDIR /productservice
COPY --from=build  /productservice/target/productservice-0.0.1-SNAPSHOT.jar productservice.jar
EXPOSE 8081
CMD [ "java" ,"-jar" , "productservice.jar"]
