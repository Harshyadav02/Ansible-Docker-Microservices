FROM openjdk:21

WORKDIR /userservice

COPY . /userservice/

EXPOSE 8083

RUN ./mvnw clean package -DskipTests

CMD [ "java" ,"-jar" , "target/userservice-0.0.1-SNAPSHOT.jar"]
