#! /bin/bash
./wait-for-it.sh cs-mysql:3306 -t 15
java -Djava.security.egd=file:/dev/./urandom -jar app.jar
