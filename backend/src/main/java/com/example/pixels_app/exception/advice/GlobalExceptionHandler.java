package com.example.pixels_app.exception.advice;

import com.example.pixels_app.exception.exceptions.CodeforcesApiException;
import com.example.pixels_app.exception.exceptions.UnauthorizedException;
import com.example.pixels_app.utils.Response;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // Handle validation errors from @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getAllErrors().getFirst().getDefaultMessage();
        return Response.errorMessage(errorMessage, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(CodeforcesApiException.class)
//    public Mono<ResponseEntity<Map<String, Object>>> handleCodeforcesApiException(CodeforcesApiException ex) {
//        return Mono.just(
//                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
//                        Map.of(
//                                "status", "error",
//                                "message", ex.getMessage()
//                        )
//                )
//        );
//    }
// Exception handler for CodeforcesApiException
    @ExceptionHandler(CodeforcesApiException.class)
    public ResponseEntity<String> handleCodeforcesApiException(CodeforcesApiException ex) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(STR."Error accessing Codeforces API: \{ex.getMessage()}");
    }
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<HashMap<String, Object>> handleUnauthorizedException(UnauthorizedException ex) {
        return Response.unauthorized();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Mono<ResponseEntity<Map<String, Object>>> handleIllegalArgument(IllegalArgumentException ex) {
        return Mono.just(
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        Map.of(
                                "status", "error",
                                "message", ex.getMessage()
                        )
                )
        );
    }

    // Handle constraint violations (e.g., @NotBlank)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<HashMap<String, Object>> handleConstraintViolation(ConstraintViolationException ex) {
        String message = ex.getConstraintViolations().iterator().next().getMessage();
        return Response.errorMessage(message, HttpStatus.BAD_REQUEST);
    }

    // Handle all other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<HashMap<String, Object>> handleAllExceptions(Exception ex) {
        System.out.println(ex.toString());
        return Response.errorMessage(
                STR."An unexpected error occurred: \{ex.getMessage()}",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
