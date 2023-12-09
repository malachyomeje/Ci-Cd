

FROM openjdk:17-jdk

WORKDIR /app

COPY target/cicd-0.0.1-SNAPSHOT.jar /app/cicd.jar

EXPOSE 8088

CMD ["java", "-jar", "cicd.jar"]