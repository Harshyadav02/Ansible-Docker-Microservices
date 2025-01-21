FROM maven:3.9.2-eclipse-temurin-17-alpine as build
WORKDIR /serviceregistry

COPY . /serviceregistry/
RUN ./mvnw clean package -DskipTests


FROM openjdk:21

WORKDIR /serviceregistry

COPY --from=build serviceregistry/target/serviceregistry-0.0.1-SNAPSHOT.jar serviceregistry.jaaaar

EXPOSE 8761

CMD [ "java", "-jar" , "serviceregistry.jar" ]