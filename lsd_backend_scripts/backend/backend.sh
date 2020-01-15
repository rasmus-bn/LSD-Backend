#!/bin/bash
#docker run -p -d 8082:8080 --name "backend" --restart on-failure \
docker run --rm -p 8082:8080 --name "backend" \
-v $(pwd)/wildfly/domain.xml:/opt/jboss/wildfly/domain/configuration/domain.xml \
-v $(pwd)/wildfly/standalone.xml:/opt/jboss/wildfly/standalone/configuration/standalone.xml \
rasmusbn/lsd-backend:latest
