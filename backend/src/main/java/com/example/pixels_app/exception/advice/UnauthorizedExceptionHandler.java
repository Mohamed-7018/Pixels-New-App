package com.example.pixels_app.exception.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.pixels_app.exception.UnauthorizedException;
import com.example.pixels_app.utils.Response;

import java.util.HashMap;

@ControllerAdvice
public class UnauthorizedExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<HashMap<String, Object>> handleUnauthorizedException(UnauthorizedException e) {
        return Response.unauthorized();
    }
}
