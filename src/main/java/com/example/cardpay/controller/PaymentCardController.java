package com.example.cardpay.controller;

import com.example.cardpay.entity.CommonResponse;
import com.example.cardpay.entity.dto.CreatePaymentRequest;
import com.example.cardpay.entity.dto.SearchPaymentRequest;
import com.example.cardpay.service.PaymentCardServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentCardController {

    private PaymentCardServiceImpl paymentCardService;

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public HashMap<String, CommonResponse> searchPayment(SearchPaymentRequest searchPaymentRequest) {
        HashMap<String, CommonResponse> response = new HashMap<>();
        ResponseEntity.ok(response);
        return response;
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public HashMap<String, Object> createPayment(CreatePaymentRequest createPaymentRequest) {
        HashMap<String, Object> response = new HashMap<>();
        paymentCardService.insertCardPayment(createPaymentRequest);
        return response;
    }

}
