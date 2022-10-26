package com.example.cardpay.service;

import com.example.cardpay.entity.dao.PaymentCard;
import com.example.cardpay.entity.ResponseDTO;
import com.example.cardpay.entity.dto.SearchPaymentRequest;

public interface PaymentCardService {
    void insertCardPayment(PaymentCard paymentCard);
    ResponseDTO findBySearchOption(SearchPaymentRequest searchOption);
}
