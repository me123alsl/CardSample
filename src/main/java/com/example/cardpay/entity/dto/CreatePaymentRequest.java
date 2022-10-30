package com.example.cardpay.entity.dto;

import com.example.cardpay.entity.dao.CardCompany;
import com.example.cardpay.entity.dao.Store;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentRequest {
    private String user;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime paymentDate;
    private String cardNumber;
    private String cardCompany;
    private String storeName;
    private Long paymentAmount;
}
