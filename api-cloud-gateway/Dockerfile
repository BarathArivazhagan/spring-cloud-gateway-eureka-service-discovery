FROM openjdk:8-jdk-alpine
MAINTAINER BARATH
VOLUME /tmp
ADD target/api-cloud-gateway-*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]