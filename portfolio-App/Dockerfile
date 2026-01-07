# =========================
# STAGE 1: BUILD WITH MAVEN
# =========================
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml first for dependency caching
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src src

# Build WAR
RUN mvn clean package -DskipTests


# =========================
# STAGE 2: DEPLOY ON TOMCAT
# =========================
FROM tomcat:9.0.85-jdk17-temurin

# Remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR to ROOT
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
