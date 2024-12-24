FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/2-order-service-0.0.1-SNAPSHOT app2.jar
EXPOSE 8100
ENTRYPOINT ["java", "-jar", "app.jar"]
