# ===== STAGE 1: Build =====
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom first (cache-friendly)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source and hibernate config
COPY portfolio-App/pom.xml .
COPY portfolio-App/src ./src
COPY portfolio-App/hibernate.cfg.xml .


# Build WAR
RUN mvn clean package -DskipTests

# ===== STAGE 2: Runtime =====
FROM tomcat:10.1-jdk17-temurin
WORKDIR /usr/local/tomcat

# Remove default apps
RUN rm -rf webapps/*

# Copy WAR
COPY --from=build /app/target/*.war webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]



