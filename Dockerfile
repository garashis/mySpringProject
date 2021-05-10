FROM openjdk:8-jdk-alpine
MAINTAINER ashish
COPY target//mySpringProject-0.0.1-SNAPSHOT.jar mySpringProject.jar
ENTRYPOINT ["java","-jar","/mySpringProject.jar"]