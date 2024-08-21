FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} replyservice.jar

ENTRYPOINT ["java", "-jar", "/replyservice.jar"]

EXPOSE 9004
