FROM maven:3.8.2-openjdk-11 AS bulid
ADD . /notification-service
WORKDIR /notification-service
RUN mvn clean package -Dmaven.test.skip=true

FROM adoptopenjdk/openjdk11:jdk-11.0.10_9-alpine AS final
ARG  JAR_FILE=/notification-service/target/*.jar
COPY --from=0 ${JAR_FILE} /notification-service.jar
ENTRYPOINT ["java","-jar", "/notification-service.jar"]