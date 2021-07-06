FROM maven:3.8.1-jdk-11-slim as maven

COPY ./pom.xml ./pom.xml
COPY ./src ./src
RUN mvn clean install

COPY ./target/mars-rover.jar ./app/mars-rover.jar
WORKDIR ./app

ENTRYPOINT ["java", "-jar", "./mars-rover.jar"]
CMD ["position", "command", "obstacles"]