FROM openjdk:21

WORKDIR /productservice

COPY . /productservice/

EXPOSE 8081

RUN ./mvnw clean package -DskipTests

CMD [ "java" ,"-jar" , "target/productservice-0.0.1-SNAPSHOT.jar"]
