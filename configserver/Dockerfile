FROM anapsix/alpine-java:8_server-jre
ADD target/*.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xmx1024m","-Xss1m","-jar","/app.jar"]
