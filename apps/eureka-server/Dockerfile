FROM amazoncorretto:25-alpine3.22-jdk
ADD target/app.jar /home/app.jar
WORKDIR /home/
ENV EUREKA_HOST=localhost
ENV EUREKA_PORT=8761
CMD java -jar app.jar