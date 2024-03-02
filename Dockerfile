FROM openjdk:11
ADD target/calculator.jar calculator.jar
ENTRYPOINT ["bash"]
