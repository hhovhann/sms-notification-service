package com.hhovhann.smsnotificationservice.service;

import com.twilio.Twilio;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SmsNotificationService implements NotificationService {
    @Value("${twilio.account.sid:localTwilioAccountSid}")
    private String twilioAccountSid;
    @Value("${twilio.auth.token:localTwilioAuthToken}")
    private String twilioAuthToken;

    @Override
    public String sendNotification(String toNumber, String fromNumber) {
        try {
            // Find your Account Sid and Token at twilio.com/console
            // DANGER! This is insecure. See http://twil.io/secure
            Twilio.init(twilioAccountSid, twilioAuthToken);

            Message.creator(
                            phoneNumberFromString("+" + toNumber),
                            phoneNumberFromString("+" + fromNumber),
                            "Hello from Twilio 📞")
                    .create();
        } catch (TwilioException e) {
            log.error("Error makeCall: " + e.getMessage(), e);
            return "Message sent unsuccessfully";
        }
        log.info("Sending SMS notification from {} to {} with {} characters", "+" + fromNumber, "+" + toNumber, "Hello from Twilio 📞".length());
        return "Message sent successfully";
    }

    /**
     * Create a @see com.twilio.types.PhoneNumber from a string
     *
     * @param pn PhoneNumber to convert
     * @return built @see com.twilio.types.PhoneNumber
     */
    private static PhoneNumber phoneNumberFromString(final String pn) {
        return new PhoneNumber(pn);
    }
}
