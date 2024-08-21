FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} tweetservice.jar

ENTRYPOINT ["java", "-jar", "/tweetservice.jar"]

EXPOSE 9002
