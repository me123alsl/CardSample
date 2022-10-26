package com.example.cardpay.entity;

import lombok.Builder;

import java.util.Optional;

@Builder
public class ResponseDTO {
    private int statusCode;
    private Object data;
    private String message;
}

