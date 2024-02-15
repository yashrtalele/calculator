FROM openjdk:11
ADD /Users/yash/.jenkins/workspace/CICD/target/calculator.jar calculator.jar
ENTRYPOINT ["java", "-jar","calculator.jar"]
EXPOSE 8080

