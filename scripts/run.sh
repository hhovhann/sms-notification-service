#/bin/sh
mvn clean packge -DskipTests && java -jar ./target/notification-service-1.0.0-SNAPSHOT.jar
