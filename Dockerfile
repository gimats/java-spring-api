FROM openjdk:17-jdk-alpine

# Copy JAR ke container
COPY target/product-v1.jar app-v1.jar

# Expose port 8080
EXPOSE 8080

# Jalankan Spring Boot
ENTRYPOINT ["java", "-jar", "app-v1.jar"]

#FROM ubuntu:latest
#LABEL authors="Yanggi"
#FROM openjdk:17-jdk-alpine

# Copy the JAR file into the container
#COPY target/product-v1.jar app-v1.jar

# Expose port 8080 (Spring Boot default)
#EXPOSE 8080

# Define the entry point to run your application
#ENTRYPOINT ["java", "-jar", "app-v1.jar"]


#ENTRYPOINT ["top", "-b"]

# Use the official MySQL Docker image
#FROM mysql:latest

# Set the MySQL root password (replace with your desired password)
#ENV MYSQL_ROOT_PASSWORD="admin123"
#ENV MYSQL_ROOT_PASSWORD=yes
#ENV MYSQL_ALLOW_EMPTY_PASSWORD=yes

# Set a non-root user and password (replace with your desired username and password)
#ENV MYSQL_USER=dbuser
#ENV MYSQL_ROOT_PASSWORD=yes
#ENV MYSQL_PASSWORD="admin123"
#ENV MYSQL_ALLOW_EMPTY_PASSWORD=yes

# (Optional) Create a new database (replace with your desired database name)
#ENV MYSQL_DATABASE=store_database

# Expose the MySQL port
#EXPOSE 3306