package com.hhovhann.smsnotificationservice.controller;

import com.hhovhann.smsnotificationservice.model.sms.SmsRequestBody;
import com.hhovhann.smsnotificationservice.model.sms.SmsResponseBody;
import com.hhovhann.smsnotificationservice.service.SmsNotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/")
public class SmsController {
    private final SmsNotificationService smsNotificationService;

    public SmsController(SmsNotificationService smsNotificationService) {
        this.smsNotificationService = smsNotificationService;
    }

    @PostMapping(value = "/sms")
    public ResponseEntity<SmsResponseBody> sendSMS(@RequestBody SmsRequestBody smsRequestBody) {
        return new ResponseEntity<>(smsNotificationService.sendNotification(smsRequestBody), OK);
    }
}
