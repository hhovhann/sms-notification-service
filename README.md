# Notification Service Software Document

## Software Environment

* Spring Boot 2.7.0
* Java "17"
+ Maven 3.8.2

## Software Behaviour
System designed as a Spring Boot Web Application. Provides Rest API with following endpoints:

- Send SMS
```
* Send notification sms
    
    POST /api/v1/noticications/sms HTTP/1.1
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

- Send Email
```
* Send notification email
    
    POST /api/v1/notifications/email HTTP/1.1
    Content-Type: application/json
    Request body:
    {
      "messageBody": "Hello from Gmail",
      "receiverNumber": "37491242491"
    }
    
    STATUS 200: Successfully Response: 
    Response Body: "Message sent successfully"
    
    STATUS 500: UnSuccessfully Response: 
    Response Body: "Message sent unsuccessfully"
    
```


### Software Environment Variables
- SMS Configuration Environment Variables
  - TWILIO_ACCOUNT_SID - your registered twilio account SID
  - TWILIO_AUTH_TOKEN - your registered twilio auth token
  - TWILIO_PHONE_NUMBER - your registered twilio phone number
- SMS Configuration Environment Variables
  - EMAIL_HOST - your registered email host
  - EMAIL_PORT - your registered email port
  - EMAIL_USERNAME - your registered email sender username
  - EMAIL_PASSWORD - your registered sender password

## Software Run
- Run application with bach command from project root `./scripts/run.sh`
- Run the application from the IDEA with TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN and TWILIO_PHONE_NUMBER env variables
- Run as a docker container
    - `docker build -t notification-service:v1 .`
    - `docker run -d --name notification-service -p 8080:8080 -e TWILIO_ACCOUNT_SID={your registered twilio account SID} -e TWILIO_AUTH_TOKEN={your registered twilio auth token} -e TWILIO_PHONE_NUMBER{your registered twilio phone number} -e TWILIO_PHONE_RECEIVER_NUMBER={your receiver number} -e EMAIL_HOST={your email host} -e EMAIL_PORT={your email port} -e EMAIL_USERNAME={your email username} EMAIL_PASSWORD={your email password} notification-service:v1`


## Improvements
- Unit/Integration Tests are missing for Sms and Email sending
