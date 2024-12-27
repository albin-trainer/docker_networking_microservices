FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/3-eureka-naming-server-0.0.1-SNAPSHOT.jar app3.jar
EXPOSE 8100
ENTRYPOINT ["java", "-jar", "app3.jar"]
