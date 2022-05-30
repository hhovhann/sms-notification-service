# Software Document

## Software Environment

* Spring Boot 2.7.0
* Java "17" 2021-09-14 LTS
+ Maven 3.8.2

## Software Behaviour
System designed as a Spring Boot Web Application. Provides Rest API with following endpoints:

- Send SMS
```
* Send SMS to number
    POST /v1/api/sms/{to_number}/{twilio_from_number}
    POST /v1/api/sms/374123456789/1234567890    
```

### Software Environment Variables
- TWILIO_ACCOUNT_SID - your registered twilio account SID
- TWILIO_AUTH_TOKEN - your registered twilio auth token

## Software Run
- Run application with bach command from project root `./scripts/run.sh`
- Run the application from the IDEA with TWILIO_ACCOUNT_SID and TWILIO_AUTH_TOKEN env variables
