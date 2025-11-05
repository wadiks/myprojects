FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/docker-1.4-SNAPSHOT.jar app.jar
EXPOSE 8000
CMD ["java", "-jar", "app.jar"]