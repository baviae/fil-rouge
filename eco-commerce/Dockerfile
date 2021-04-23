FROM maven:3.6.3-jdk-11-slim
RUN mkdir /app
ADD ./target/eco-commerce-0.0.1-SNAPSHOT.jar  /app/eco-commerce-0.0.1-SNAPSHOT.jar
RUN mvn -f /app/pom.xml install
WORKDIR /app
CMD "java" "-jar" "eco-commerce-0.0.1-SNAPSHOT.jar"
