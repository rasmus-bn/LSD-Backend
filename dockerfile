FROM maven:3.3-jdk-8 AS build-env

COPY my-app /app
COPY settings.xml /root/.m2/settings.xml
WORKDIR /app
RUN mvn clean package

FROM tomcat:9.0.1-alpine

COPY --from=build-env /app/target/4.war /usr/local/tomcat/webapps/4.war
EXPOSE 8080