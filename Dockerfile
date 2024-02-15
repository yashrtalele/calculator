FROM openjdk:11
ADD //Users/yash/.jenkins/workspace/CICD/target/simple-maven-project-with-tests-1.0-SNAPSHOT.jar calculator.jar
ENTRYPOINT ["java", "-jar","calculator.jar"]
EXPOSE 8080

