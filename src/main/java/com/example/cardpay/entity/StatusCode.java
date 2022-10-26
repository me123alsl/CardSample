package com.example.cardpay.entity;

public enum StatusCode {
    SUCCESS(200),
    FAIL(400),
    ERROR(500);
    private int statusCode;
    StatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
