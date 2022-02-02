#!/bin/bash
java -jar ms-eureka-0.0.1-SNAPSHOT.jar &
java -jar gif-app-0.0.1-SNAPSHOT.jar &
java -jar ms-gateway-0.0.1-SNAPSHOT.jar &
java -jar ms-oauth-0.0.1-SNAPSHOT.jar &
java -jar ms-users-0.0.1-SNAPSHOT.jar &
