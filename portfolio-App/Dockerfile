# =========================
# STAGE 1: Build WAR
# =========================
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy POM first (dependency cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src
COPY hibernate.cfg.xml .

# Build WAR
RUN mvn clean package -DskipTests

# =========================
# STAGE 2: Deploy on Tomcat
# =========================
FROM tomcat:10.1-jdk17-temurin

WORKDIR /usr/local/tomcat

# Remove default apps
RUN rm -rf webapps/*

# Copy WAR
COPY --from=build /app/target/*.war webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
