package com.example.cardpay.service;

import com.example.cardpay.entity.CommonResponse;
import com.example.cardpay.entity.dao.PaymentCard;
import com.example.cardpay.entity.dto.CreatePaymentRequest;
import com.example.cardpay.entity.dto.SearchPaymentRequest;
import org.springframework.data.domain.Page;

public interface PaymentCardService {
    void insertCardPayment(CreatePaymentRequest createPaymentRequest);
    CommonResponse findBySearchOption(SearchPaymentRequest searchOption);

}
