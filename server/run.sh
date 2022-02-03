#!/bin/sh

java -jar ms-eureka-*.jar && sleep 5 &
java -jar gif-app-*.jar &
java -jar ms-gateway-*.jar &
java -jar ms-oauth-*.jar &
java -jar ms-users-*.jar