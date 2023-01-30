FROM adoptopenjdk/openjdk11:alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} votacao-associados.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/votacao-associados.jar"]