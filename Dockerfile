# FROM eclipse-temurin:17-jdk-alpine
# WORKDIR /app
# CMD ["./gradlew", "build"]
# ARG JAR_FILE
# COPY ./build/libs/*.jar app.jar
# ENTRYPOINT ["java","-jar","/build/libs/*.jar"]
FROM gradle:7.6.1-jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon 

FROM eclipse-temurin:17-jdk-alpine

ENV DB_USERNAME=root
ENV DB_HOSTNAME=hackaton.cgyb6kofcgif.us-east-1.rds.amazonaws.com
ENV DB_PORT=3306
ENV DB_PASSWORD=12345678
ENV DB_NAME=hackaton

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java", "-jar","/app/spring-boot-application.jar"]