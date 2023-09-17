package com.dailycodework.ilibrary.exception;

import com.dailycodework.ilibrary.Utils.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookAPIException.class)
    public ResponseEntity<ErrorMessage> handleBookApiException(BookAPIException exception, WebRequest webRequest) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGlobalException(Exception exception, WebRequest webRequest) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorMessage> handleAccessDeniedException(AccessDeniedException exception, WebRequest webRequest) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
    }
}
