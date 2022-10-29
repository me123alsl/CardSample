package com.example.cardpay.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResponse<T> {
    private int statusCode;
    private T data;
    private String message;
}

