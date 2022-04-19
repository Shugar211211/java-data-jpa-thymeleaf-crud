FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S crudJava -G crudJava
USER crudJava:crudJava
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
