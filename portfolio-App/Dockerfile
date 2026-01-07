# Step 1: Use a Tomcat base image with Java 17+
FROM tomcat:10.1-jdk17-temurin

# Step 2: Set working directory inside the container
WORKDIR /usr/local/tomcat

# Step 3: Remove default Tomcat apps to keep it clean
RUN rm -rf webapps/*

# Step 4: Copy your WAR file from your local target folder 
# into the Tomcat webapps directory as ROOT.war
COPY target/portfolio-App.war webapps/ROOT.war

# Step 5: (Optional) If you have a separate MySQL driver JAR, 
# you can copy it to Tomcat's lib folder
# COPY lib/mysql-connector-j-x.x.x.jar lib/

# Step 6: Expose the default Tomcat port
EXPOSE 8080

# Step 7: Start Tomcat
CMD ["catalina.sh", "run"]
