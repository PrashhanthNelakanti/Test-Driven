FROM openjdk:8
EXPOSE 8080
ADD target/tdd.jar tdd.jar
ENTRYPOINT ["java","-jar","/tdd.jar"]