package com.hhovhann.notificationservice.model.sms;

import lombok.Data;

@Data
public class NotificationRequestBody {
    String messageBody;
    String receiver;
}
