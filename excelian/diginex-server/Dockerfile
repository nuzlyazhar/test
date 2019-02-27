FROM openjdk:latest
MAINTAINER mazhar@luxoft.com
WORKDIR /opt/springbootapp/
ADD target/diginex-server-0.0.1-SNAPSHOT.jar /opt/springbootapp/
RUN chmod +x diginex-server-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "diginex-server-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080