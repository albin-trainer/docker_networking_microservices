FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/2-order-service-0.0.1-SNAPSHOT.jar app2.jar
EXPOSE 8100
ENTRYPOINT ["java", "-jar", "app2.jar"]
