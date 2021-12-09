#Dockerfile for order-service

FROM openjdk:11
EXPOSE  8096
COPY ./target/Authentication-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]