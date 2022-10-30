package com.example.cardpay.excetpion;

import com.example.cardpay.entity.dto.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    protected ResponseEntity<?> handleException(HttpMessageNotReadableException e) {
        CommonResponse response = CommonResponse.builder()
                .statusCode(500)
                .data(null)
                .message("요청데이터 형식이 올바르지 않습니다.")
                .build();
        return ResponseEntity.badRequest().body(response);
    }
    @ExceptionHandler(value = RestApiException.class)
    protected ResponseEntity<?> handleException(RestApiException e) {
        CommonResponse response = CommonResponse.builder()
                .statusCode(e.getErrorCode().getHttpStatus().value())
                .data(null)
                .message(e.getErrorCode().getMessage())
                .build();
        return ResponseEntity.badRequest().body(response);
    }

}
