FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} likeservice.jar

ENTRYPOINT ["java", "-jar", "/likeservice.jar"]

EXPOSE 9003
