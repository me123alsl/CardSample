package com.example.cardpay.excetpion;

import com.example.cardpay.entity.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<?> handleException(Exception e) {
        CommonResponse response = CommonResponse.builder()
                .statusCode(500)
                .data(null)
                .message(e.getMessage())
                .build();
        return ResponseEntity.badRequest().body(response);
    }
}
