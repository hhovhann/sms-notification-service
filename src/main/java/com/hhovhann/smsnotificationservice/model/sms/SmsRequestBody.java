package com.hhovhann.smsnotificationservice.model.sms;

import lombok.Data;

@Data
public class SmsRequestBody {
    String messageBody;
    String receiverNumber;
}
