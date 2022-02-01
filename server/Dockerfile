FROM openjdk:11-jdk-slim

RUN mkdir /usr/microservices

COPY ./ms-eureka/build/libs/*-SNAPSHOT.jar /usr/microservices
COPY ./gif-app/build/libs/*-SNAPSHOT.jar /usr/microservices
COPY ./ms-gateway/build/libs/*-SNAPSHOT.jar /usr/microservices
COPY ./ms-oauth/build/libs/*-SNAPSHOT.jar /usr/microservices
COPY ./ms-users/build/libs/*-SNAPSHOT.jar /usr/microservices
COPY ./ms-zuul/build/libs/*-SNAPSHOT.jar /usr/microservices

WORKDIR /usr/microservices

ENTRYPOINT ["/bin/bash"]
