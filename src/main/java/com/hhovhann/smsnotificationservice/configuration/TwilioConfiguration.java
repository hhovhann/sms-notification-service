package com.hhovhann.smsnotificationservice.configuration;

import com.twilio.Twilio;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Data
@Configuration
public class TwilioConfiguration {
    @Value("${twilio.account.sid:localTwilioAccountSid}")
    private String twilioAccountSid;
    @Value("${twilio.auth.token:localTwilioAuthToken}")
    private String twilioAuthToken;
    @Value("${twilio.phone.number:localTwilioAuthToken}")
    private String twilioPhoneNumber;

    @PostConstruct
    public void init() {
        Twilio.init(getTwilioAccountSid(), getTwilioAuthToken());
    }
}
