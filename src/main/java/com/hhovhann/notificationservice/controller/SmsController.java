package com.hhovhann.notificationservice.controller;

import com.hhovhann.notificationservice.model.sms.NotificationRequestBody;
import com.hhovhann.notificationservice.model.sms.NotificationResponseBody;
import com.hhovhann.notificationservice.service.EmailNotificationService;
import com.hhovhann.notificationservice.service.SmsNotificationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@Tag(name = "Notification Endpoints")
@RequestMapping("/api/v1/notifications")
public class SmsController {
    private final SmsNotificationService smsNotificationService;
    private final EmailNotificationService emailNotificationService;

    public SmsController(SmsNotificationService smsNotificationService, EmailNotificationService emailNotificationService) {
        this.smsNotificationService = smsNotificationService;
        this.emailNotificationService = emailNotificationService;
    }

    @PostMapping(value = "/sms")
    public ResponseEntity<NotificationResponseBody> sendSMS(@RequestBody NotificationRequestBody requestBody) {
        return new ResponseEntity<>(smsNotificationService.sendNotification(requestBody), OK);
    }

    @PostMapping(value = "/email")
    public ResponseEntity<NotificationResponseBody> sendEmail(@RequestBody NotificationRequestBody requestBody) {
        return new ResponseEntity<>(emailNotificationService.sendNotification(requestBody), OK);
    }
}
