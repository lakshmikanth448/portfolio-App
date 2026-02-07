# ===== STAGE 1: BUILD =====
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

COPY portfolio-App/pom.xml .
RUN mvn dependency:go-offline

COPY portfolio-App/src ./src

RUN mvn clean package -DskipTests


# ===== STAGE 2: RUN =====
FROM tomcat:10.1-jdk17-temurin

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
