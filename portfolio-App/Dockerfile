# STAGE 1: Build the WAR file using Maven
# Uses the 'maven:3.9' image with JDK 17
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copy the pom.xml file first to optimize Docker caching
COPY pom.xml .
RUN mvn dependency:go-offline # Download dependencies

# Copy the source code folder you have (src/main)
COPY src/main ./src/main

# Build the project into a .war file in the target/ folder
RUN mvn clean package -DskipTests

# STAGE 2: Deploy to Tomcat
# Uses the 'tomcat:10.1' image with JDK 17
FROM tomcat:10.1-jdk17-temurin
WORKDIR /usr/local/tomcat

# Clean up default webapps
RUN rm -rf webapps/*

# Copy the built WAR file from the 'build' stage and rename it to ROOT.war
COPY --from=build /app/target/*.war webapps/ROOT.war

# Expose the default Tomcat port
EXPOSE 8080

# Start the Tomcat server
CMD ["catalina.sh", "run"]
