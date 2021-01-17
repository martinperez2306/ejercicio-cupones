#!/bin/bash

sh buildAPI.sh;

echo "Levantando API REST de Cupones";
java -jar coupons-apirest/target/coupons-apirest-0.0.1.jar;
