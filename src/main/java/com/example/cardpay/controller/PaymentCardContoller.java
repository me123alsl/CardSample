package com.example.cardpay.controller;

import com.example.cardpay.entity.ResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentCardContoller {

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public HashMap<String, ResponseDTO> searchPayment() {
        HashMap<String, ResponseDTO> response = new HashMap<>();
        return response;
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public String createPayment() {
        return "payment";
    }

}
