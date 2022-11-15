FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:nexus -o tpAchatProject-1.0.jar "http://192.168.1.16:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar" -L
ENTRYPOINT java -jar /achat-1.0.jar
EXPOSE 8089