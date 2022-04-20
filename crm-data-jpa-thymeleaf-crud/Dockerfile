FROM adoptopenjdk/openjdk11:alpine
RUN addgroup -S crudJava && adduser -S crudJava -G crudJava
USER crudJava:crudJava
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
