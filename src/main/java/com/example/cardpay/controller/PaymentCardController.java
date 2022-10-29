package com.example.cardpay.controller;

import com.example.cardpay.entity.CommonResponse;
import com.example.cardpay.entity.dto.CreatePaymentRequest;
import com.example.cardpay.entity.dto.SearchPaymentRequest;
import com.example.cardpay.service.PaymentCardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
public class PaymentCardController {
    @Autowired
    PaymentCardServiceImpl paymentCardService;

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public CommonResponse searchPayment(@RequestBody SearchPaymentRequest searchPaymentRequest) {
        return paymentCardService.findBySearchOption(searchPaymentRequest);
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public HashMap<String, Object> createPayment(@RequestBody CreatePaymentRequest createPaymentRequest) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("data", createPaymentRequest);
        paymentCardService.insertCardPayment(createPaymentRequest);
        return response;
    }

}
