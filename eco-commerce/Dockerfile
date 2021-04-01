FROM maven:3.6.3-jdk-11-slim@sha256:68ce1cd457891f48d1e137c7d6a4493f60843e84c9e2634e3df1d3d5b381d36c
RUN mvn -f ~/fil-rouge/eco-commerce/pom.xml install -DskipTests
RUN mkdir /app
COPY ./target/eco-commerce-0.0.1-SNAPSHOT.jar /app/eco-commerce-0.0.1-SNAPSHOT.jar
WORKDIR /app
CMD "java" "-jar" "eco-commerce-0.0.1-SNAPSHOT.jar"
