FROM ibm-semeru-runtimes:open-17-jre
COPY target/Primary-0.0.1-SNAPSHOT.jar spring-cloud-open-telemetry.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/spring-cloud-open-telemetry.jar"]