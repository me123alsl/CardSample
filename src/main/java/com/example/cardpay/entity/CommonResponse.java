package com.example.cardpay.entity;

import lombok.Builder;

import java.net.http.HttpResponse;
import java.util.List;

@Builder
public class CommonResponse<T> {
    private int statusCode;
    private T data;
    private String message;
}

