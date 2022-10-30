package com.example.cardpay.controller;

import com.example.cardpay.entity.dto.CommonResponse;
import com.example.cardpay.entity.dto.CreatePaymentRequest;
import com.example.cardpay.entity.dto.SearchPaymentRequest;
import com.example.cardpay.service.PaymentCardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentCardController {
    @Autowired
    PaymentCardServiceImpl paymentCardService;

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public CommonResponse searchPayment(@RequestBody SearchPaymentRequest searchPaymentRequest)
            throws RuntimeException {
        return paymentCardService.findBySearchOption(searchPaymentRequest);
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public CommonResponse createPayment(@RequestBody CreatePaymentRequest createPaymentRequest)
            throws RuntimeException {
        return paymentCardService.insertCardPayment(createPaymentRequest);
    }

    // Tomcat Properties Setting Test
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String createPayment() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "test";
    }
}
