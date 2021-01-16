#!/bin/bash

echo "CORRIENDO TEST CON MAVEN";
mvn clean test -f coupons-pom.xml;
