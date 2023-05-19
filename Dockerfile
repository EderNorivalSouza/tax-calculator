FROM openjdk:17
ADD /target/tax-calculator-1.0-jar-with-dependencies.jar tax-calculator-1.0.jar
ENTRYPOINT ["java", "-jar", "tax-calculator-1.0.jar"]
EXPOSE 8080