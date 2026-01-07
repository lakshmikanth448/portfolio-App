# STAGE 1: Build
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY /target
RUN mvn clean package -DskipTests

# STAGE 2: Deploy
FROM tomcat:10.1-jdk17-temurin
WORKDIR /usr/local/tomcat
RUN rm -rf webapps/*
COPY --from=build /app/target/*.war webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]




