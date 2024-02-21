FROM openjdk:21-oracle
ARG JAR_FILE=target/=.jar
COPY ./target/concurrency-management-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]