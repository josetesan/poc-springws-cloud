FROM anapsix/alpine-java:7_server-jre
ADD target/*.jar /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xmx512m","-Xss1m","-jar","/app.jar"]