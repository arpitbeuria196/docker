FROM eclipse-temurin:17-jre
WORKDIR /opt/app
COPY target/docker-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/app/app.jar"]