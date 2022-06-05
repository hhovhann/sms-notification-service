#/bin/sh
mvn clean install -DskipTests && java -jar ./target/notification-service-1.0.0-SNAPSHOT.jar
