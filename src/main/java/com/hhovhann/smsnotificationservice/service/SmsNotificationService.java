package com.hhovhann.smsnotificationservice.service;

import com.hhovhann.smsnotificationservice.configuration.TwilioConfiguration;
import com.hhovhann.smsnotificationservice.model.sms.SmsRequestBody;
import com.hhovhann.smsnotificationservice.model.sms.SmsResponseBody;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SmsNotificationService implements NotificationService {

    private final TwilioConfiguration twilioConfiguration;

    public SmsNotificationService(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }


    @Override
    public SmsResponseBody sendNotification(SmsRequestBody smsRequestBody) {
        try {
            Message.creator(
                            phoneNumberFromString(smsRequestBody.getReceiverNumber()),
                            phoneNumberFromString(twilioConfiguration.getTwilioPhoneNumber()),
                         smsRequestBody.getMessageBody())
                       .create();
        } catch (TwilioException e) {
            log.error("Error makeCall: " + e.getMessage(), e);
            return new SmsResponseBody("Message sent unsuccessfully");
        }
        log.info("Sending SMS notification from {} to {} with {} characters", "+" + twilioConfiguration.getTwilioPhoneNumber(), "+" + smsRequestBody.getReceiverNumber(), smsRequestBody.getMessageBody().length());
        return new SmsResponseBody("Message sent successfully");
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
