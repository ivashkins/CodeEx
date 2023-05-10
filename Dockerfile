FROM openjdk:18
COPY target/CodeExample-0.0.1-SNAPSHOT.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "CodeExample-0.0.1-SNAPSHOT.jar"]
VOLUME codeexample
EXPOSE 8080