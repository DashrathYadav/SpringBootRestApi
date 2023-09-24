FROM openjdk:20
VOLUME /tmp
COPY  target/*.jar app.jar
ENTRYPOINT [ "java","-jar","/app.jar"]
EXPOSE 8080 
