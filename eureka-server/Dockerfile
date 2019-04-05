FROM openjdk:8-jdk-alpine
ADD target/eureka-server-*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]