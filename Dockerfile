FROM openjdk:11
ADD target/calculator.jar calculator.jar
ENTRYPOINT ["java", "-jar","calculator.jar"]
EXPOSE 8080

