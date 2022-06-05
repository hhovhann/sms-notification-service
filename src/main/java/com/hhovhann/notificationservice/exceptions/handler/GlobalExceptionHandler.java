package com.hhovhann.notificationservice.exceptions.handler;

import com.hhovhann.notificationservice.exceptions.NotificationServiceException;
import com.hhovhann.notificationservice.exceptions.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.StringJoiner;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final String BAD_REQUEST = "BAD_REQUEST";

    private ResponseEntity<Object> generateResponseEntity(RuntimeException ex, String badRequest, HttpStatus badRequest2) {
        return new ResponseEntity<>(new ErrorResponse(badRequest, List.of(ex.getLocalizedMessage())), badRequest2);
    }

    @ExceptionHandler(NotificationServiceException.class)
    protected ResponseEntity<Object> handleValidationException(RuntimeException ex, WebRequest request) {
        return generateResponseEntity(ex, BAD_REQUEST, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        BindingResult bindResult = ex.getBindingResult();
        List<FieldError> fieldErrorList = bindResult.getFieldErrors();
        StringJoiner message = new StringJoiner(" | ");
        fieldErrorList.forEach(fe -> message.add(fe.getDefaultMessage()));

        return new ResponseEntity<>(new ErrorResponse(message.toString(), List.of(ex.getLocalizedMessage())), HttpStatus.BAD_REQUEST);
    }
}