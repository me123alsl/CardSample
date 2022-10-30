package com.example.cardpay.service;

import com.example.cardpay.entity.dto.CommonResponse;
import com.example.cardpay.entity.dto.CreatePaymentRequest;
import com.example.cardpay.entity.dto.SearchPaymentRequest;

public interface PaymentCardService {
    CommonResponse insertCardPayment(CreatePaymentRequest createPaymentRequest);
    CommonResponse findBySearchOption(SearchPaymentRequest searchOption);

}
