# base image
FROM openjdk:8

# update packages and install maven
WORKDIR /usr/src/app

ADD ./target/zpy-upload-0.0.1.jar /usr/src/app/app.jar

CMD ["java", "-jar", "/usr/src/app/app.jar"]
