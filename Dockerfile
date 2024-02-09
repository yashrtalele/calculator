ARG HOME_APP=/var/lib/jenkins/workspace/Pull_Code_From_Github_Job/

FROM maven:3.8.3-openjdk-17 as maven_build
ARG HOME_APP
WORKDIR $HOME_APP
ADD pom.xml .
RUN mvn verify --fail-never
ADD . .
RUN mvn package

FROM eclipse-temurin:17-jre-jammy
ARG HOME_APP
WORKDIR $HOME_APP
COPY --from=maven_build $HOME_APP/target/calculator.jar
ENTRYPOINT ["java", "-jar", "calculator.jar"]
