FROM maven:3.6.3-jdk-11-slim@sha256:68ce1cd457891f48d1e137c7d6a4493f60843e84c9e2634e3df1d3d5b381d36c
RUN mvn clean package -DskipTests
RUN mkdir /app
COPY ./target/java-application.jar /app/java-application.jar
WORKDIR /app
CMD "java" "-jar" "java-application.jar"
