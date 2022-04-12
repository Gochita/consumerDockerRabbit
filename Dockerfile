FROM openjdk:11
ADD target/consumer-0.0.1-SNAPSHOT.jar consumer.jar
RUN sh -c 'touch /consumer.jar'
ENTRYPOINT ["java", "-jar","consumer.jar"]
EXPOSE 8081