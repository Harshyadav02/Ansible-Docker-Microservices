FROM openjdk:21

WORKDIR /gatway

COPY . /gatway/

EXPOSE 8080

RUN ./mvnw clean package -DskipTests

CMD [ "java", "-jar" , "target/gatway-0.0.1-SNAPSHOT.jar" ]