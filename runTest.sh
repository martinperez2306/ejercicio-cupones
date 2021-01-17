#!/bin/bash

echo "CORRIENDO TEST CON MAVEN";
./mvnw clean test -f coupons-pom.xml;
