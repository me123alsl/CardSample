package com.example.cardpay.entity.dao;


import lombok.Data;

@Data
public class PaymentCardDAO {
    private String user;
    private String paymentDate;
    private String cardNumber;
    private String cardCompany;
    private String storeName;
    private int paymentAmount;
}

