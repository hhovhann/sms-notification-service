package com.hhovhann.smsnotificationservice.controller;

import com.hhovhann.smsnotificationservice.service.SmsNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SmsController {
    private final SmsNotificationService smsNotificationService;

    public SmsController(SmsNotificationService smsNotificationService) {
        this.smsNotificationService = smsNotificationService;
    }

    @GetMapping(value = "/api/v1/sms/{to_number}/{from_number}")
    public ResponseEntity<String> sendSMS(@PathVariable("to_number") String toNumber, @PathVariable("from_number") String fromNumber) {
        return new ResponseEntity<>(smsNotificationService.sendNotification(toNumber, fromNumber), HttpStatus.OK);
    }
}
