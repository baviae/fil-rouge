FROM maven:3.6.3-jdk-11-slim
RUN mkdir /app
COPY eco-commerce-0.0.1.jar  /app/eco-commerce-0.0.1.jar
RUN mvn -f /app/pom.xml install
WORKDIR /app
CMD "java" "-jar" "eco-commerce-0.0.1.jar"
