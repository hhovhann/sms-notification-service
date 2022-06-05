package com.hhovhann.notificationservice.service;

import com.hhovhann.notificationservice.model.sms.NotificationRequestBody;
import com.hhovhann.notificationservice.model.sms.NotificationResponseBody;

public interface NotificationService {
    NotificationResponseBody sendNotification(NotificationRequestBody notificationRequestBody);
}
