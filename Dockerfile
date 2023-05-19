FROM openjdk:17
ADD /target/nu-profit-1.0-jar-with-dependencies.jar nu-profit-1.0.jar
ENTRYPOINT ["java", "-jar", "nu-profit-1.0.jar"]
EXPOSE 8080