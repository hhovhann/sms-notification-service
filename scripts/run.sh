#/bin/sh
mvn clean package -DskipTests && java -jar ./target/sms-notification-service-1.0.0-SNAPSHOT.jar -DTWILIO_ACCOUNT_SID=YOUR_TWILIO_ACCOUNT_SID -DTWILIO_AUTH_TOKEN=YOUR_TWILIO_AUTH_TOKEN