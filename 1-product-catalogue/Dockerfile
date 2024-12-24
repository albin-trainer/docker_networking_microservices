FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/1-product-catalogue-0.0.1-SNAPSHOT app1.jar
EXPOSE 8100
ENTRYPOINT ["java", "-jar", "app.jar"]
