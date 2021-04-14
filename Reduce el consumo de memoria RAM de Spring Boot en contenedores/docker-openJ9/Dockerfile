FROM adoptopenjdk:11-jre-openj9
WORKDIR /app
COPY target/performance-0.0.1.jar /app
EXPOSE 8080
CMD ["java","-jar","performance-0.0.1.jar"]