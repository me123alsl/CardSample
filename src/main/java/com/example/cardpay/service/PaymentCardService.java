package com.example.cardpay.service;

import com.example.cardpay.entity.CommonResponse;
import com.example.cardpay.entity.dto.CreatePaymentRequest;
import com.example.cardpay.entity.dto.SearchPaymentRequest;

public interface PaymentCardService {
    void insertCardPayment(CreatePaymentRequest createPaymentRequest);
    CommonResponse findBySearchOption(SearchPaymentRequest searchOption);
}
