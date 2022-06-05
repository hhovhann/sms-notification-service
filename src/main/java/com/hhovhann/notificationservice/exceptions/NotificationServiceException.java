package com.hhovhann.notificationservice.exceptions;

public class NotificationServiceException extends RuntimeException {
    private static final long serialVersionUID = -2683346099935833721L;

    public NotificationServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotificationServiceException(String message) {
        super(message);
    }

    public NotificationServiceException(Throwable cause) {
        super(cause);
    }
}