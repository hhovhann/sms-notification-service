package com.hhovhann.notificationservice.service;

import com.hhovhann.notificationservice.configuration.EmailConfiguration;
import com.hhovhann.notificationservice.model.sms.NotificationRequestBody;
import com.hhovhann.notificationservice.model.sms.NotificationResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Slf4j
@Service
public class EmailNotificationService implements NotificationService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    EmailConfiguration emailConfiguration;

    @Override
    public NotificationResponseBody sendNotification(NotificationRequestBody notificationRequestBody) {
        return sendSimpleMessage(notificationRequestBody.getReceiver(), "Email Notification", notificationRequestBody.getMessageBody());
    }

    public NotificationResponseBody sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

        return new NotificationResponseBody("Email sent successfully");
    }

    public NotificationResponseBody sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("noreply@baeldung.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);

        FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
        helper.addAttachment("Invoice", file);

        emailSender.send(message);

        return new NotificationResponseBody("Email sent successfully");
    }
}
