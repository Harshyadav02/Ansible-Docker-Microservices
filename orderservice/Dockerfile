FROM openjdk:21

WORKDIR /orderservice

COPY . /orderservice/

EXPOSE 8082

RUN ./mvnw clean package -DskipTests

CMD [ "java" ,"-jar" , "target/orderservice-0.0.1-SNAPSHOT.jar"]
