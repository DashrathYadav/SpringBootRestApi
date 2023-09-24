FROM openjdk:20
EXPOSE 8080 
VOLUME /tmp
ADD target/ServerBackEnd.jar ServerBackEnd.jar
ENTRYPOINT [ "java","-jar","/ServerBackEnd.jar"]
`