FROM maven:3.3-jdk-8 AS build-env

COPY backend /app
COPY settings.xml /root/.m2/settings.xml
WORKDIR /app
RUN mvn clean package

FROM jboss/wildfly

COPY ./wildflyConfig/standalone.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml
COPY --from=build-env /app/target/4.war /opt/jboss/wildfly/standalone/deployments/4.war
EXPOSE 8080
