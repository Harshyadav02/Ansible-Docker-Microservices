FROM openjdk:21

WORKDIR /serviceregistry

COPY . /serviceregistry/

EXPOSE 8761

RUN ./mvnw clean package -DskipTests

CMD [ "java", "-jar" , "target/serviceregistry-0.0.1-SNAPSHOT.jar" ]