FROM ibm-semeru-runtimes:open-17-jre
COPY target/Secondary-0.0.1-SNAPSHOT.jar spring-cloud-open-telemetry.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/spring-cloud-open-telemetry.jar"]