package com.hhovhann.notificationservice.service;

import com.hhovhann.notificationservice.configuration.SmsTwilioConfiguration;
import com.hhovhann.notificationservice.model.sms.NotificationRequestBody;
import com.hhovhann.notificationservice.model.sms.NotificationResponseBody;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SmsNotificationService implements NotificationService {

    private final SmsTwilioConfiguration smsTwilioConfiguration;

    public SmsNotificationService(SmsTwilioConfiguration smsTwilioConfiguration) {
        this.smsTwilioConfiguration = smsTwilioConfiguration;
    }


    @Override
    public NotificationResponseBody sendNotification(NotificationRequestBody notificationRequestBody) {
        try {
            Message.creator(
                            phoneNumberFromString(notificationRequestBody.getReceiver()),
                            phoneNumberFromString(smsTwilioConfiguration.getTwilioPhoneNumber()),
                         notificationRequestBody.getMessageBody())
                       .create();
        } catch (TwilioException e) {
            log.error("Error makeCall: " + e.getMessage(), e);
            return new NotificationResponseBody("Message sent unsuccessfully");
        }
        log.info("Sending SMS notification from {} to {} with {} characters", "+" + smsTwilioConfiguration.getTwilioPhoneNumber(), "+" + notificationRequestBody.getReceiver(), notificationRequestBody.getMessageBody().length());
        return new NotificationResponseBody("Message sent successfully");
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
