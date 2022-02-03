#!/bin/sh

cd ms-eureka &&  chmod +x ./gradlew && ./gradlew clean build -x test && cd ..
cd gif-app && chmod +x ./gradlew && ./gradlew clean build -x test && cd ..
cd ms-users && chmod +x ./gradlew && ./gradlew clean build -x test && cd ..
cd ms-oauth && chmod +x ./gradlew && ./gradlew clean build -x test && cd ..
cd ms-zuul && chmod +x ./gradlew && ./gradlew clean build -x test && cd ..
cd ms-gateway && chmod +x ./gradlew && ./gradlew clean build -x test && cd ..