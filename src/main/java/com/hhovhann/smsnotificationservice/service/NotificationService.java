package com.hhovhann.smsnotificationservice.service;

import com.hhovhann.smsnotificationservice.model.sms.SmsRequestBody;
import com.hhovhann.smsnotificationservice.model.sms.SmsResponseBody;

public interface NotificationService {
    SmsResponseBody sendNotification(SmsRequestBody smsRequestBody);
}
