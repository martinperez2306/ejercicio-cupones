#!/bin/bash
rm -rf generated/
java -jar swagger-codegen-cli.jar generate -i cupones.yaml --api-package org.mperez.coupons.rest.api --model-package org.mperez.coupons.rest.model -l spring -c config.json -o generated/
