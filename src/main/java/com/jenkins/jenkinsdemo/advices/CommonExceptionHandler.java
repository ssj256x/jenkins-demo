package com.jenkins.jenkinsdemo.advices;

import com.jenkins.jenkinsdemo.exception.ActorNotFoundException;
import com.jenkins.jenkinsdemo.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class, ActorNotFoundException.class})
    public ResponseEntity<Object> handleAll(RuntimeException re, WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(re.getClass().getSimpleName());
        errorResponse.setErrorMessage(re.getLocalizedMessage());

        return ResponseEntity.status(500).body(errorResponse);
    }
}
