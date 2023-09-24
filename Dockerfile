FROM openjdk:20
EXPOSE 8080
ADD target/ServerBackEnd.jar ServerBackEnd.jar
ENTRYPOINT [ "java","-jar","/ServerBackEnd.jar"]
