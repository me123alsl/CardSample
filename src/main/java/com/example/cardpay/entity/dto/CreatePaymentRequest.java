package com.example.cardpay.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CreatePaymentRequest {
    private String user;
    private LocalDateTime paymentDate;
    private String cardNumber;
    private String cardCompany;
    private String storeName;
    private int paymentAmount;
}
