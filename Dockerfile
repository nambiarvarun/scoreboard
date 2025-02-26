FROM openjdk:24-jdk-oracle
ARG JAR_FILE=target/*.jar
COPY ./target/scoreboard-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]