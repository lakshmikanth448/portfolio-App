# =========================
# STAGE 1: BUILD
# =========================
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy everything (except ignored files)
COPY . .

RUN mvn clean package -DskipTests


# =========================
# STAGE 2: DEPLOY
# =========================
FROM tomcat:9.0.85-jdk17-temurin

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
