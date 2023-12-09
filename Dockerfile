

FROM openjdk:17-jdk

WORKDIR /app

COPY target/springboot-cicd.jar /app/springboot-cicd.jar

EXPOSE 8088

CMD ["java", "-jar", "springboot-cicd.jar"]