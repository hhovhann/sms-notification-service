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
    
    POST /api/v1/sms HTTP/1.1
    Content-Type: application/json
    Request body:
    {
      "messageBody": "Hello from Twilio 📞",
      "receiverNumber": "37412345678"
    }
    
    STATUS 200: Successfully Response: 
    Response Body: "Message sent successfully"
    
    STATUS 500: UnSuccessfully Response: 
    Response Body: "Message sent unsuccessfully"
    
```

### Software Environment Variables
- TWILIO_ACCOUNT_SID - your registered twilio account SID
- TWILIO_AUTH_TOKEN - your registered twilio auth token
- TWILIO_PHONE_NUMBER - your registered twilio phone number

## Software Run
- Run application with bach command from project root `./scripts/run.sh`
- Run the application from the IDEA with TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN and TWILIO_PHONE_NUMBER env variables


## Improvements: Nice to have
- Could be added openAPI
- Could be added custom exceptions and global handling
- Could support list of receivers
- Integration Tests are missing for twilio e2e
- 
