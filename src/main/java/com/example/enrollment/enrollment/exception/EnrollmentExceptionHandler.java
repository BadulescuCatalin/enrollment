package com.example.enrollment.enrollment.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EnrollmentExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { StudentNotFoundException.class, CourseNotFoundException.class })
    public ResponseEntity<String> handleNotFoundException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}