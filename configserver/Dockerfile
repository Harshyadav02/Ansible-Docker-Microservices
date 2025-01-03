FROM openjdk:21

WORKDIR /configserver

COPY . /configserver/

EXPOSE 8888

RUN ./mvnw clean package -DskipTests

CMD [ "java", "-jar" , "target/configserver-0.0.1-SNAPSHOT.jar" ]
