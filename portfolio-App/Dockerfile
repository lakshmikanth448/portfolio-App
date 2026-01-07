# STAGE 1: Build the WAR file using Maven
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
# Copy your project files
COPY pom.xml 
COPY src ./src/main
# Build the project (skipping tests for speed)
RUN mvn clean package -DskipTests

# STAGE 2: Deploy to Tomcat
FROM tomcat:10.1-jdk17-temurin
WORKDIR /usr/local/tomcat
# Remove default apps
RUN rm -rf webapps/*
# Copy the built WAR from the previous 'build' stage
# Railpack/Maven usually names the file based on your pom.xml
COPY --from=build /app/target/*.war webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]

