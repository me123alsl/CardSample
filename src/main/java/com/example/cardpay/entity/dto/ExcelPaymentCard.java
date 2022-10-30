package com.example.cardpay.entity.dto;

import com.example.cardpay.entity.dao.CardCompany;
import com.example.cardpay.entity.dao.Store;
import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;
import lombok.*;

import java.time.LocalDateTime;

@Setter @Getter
@ToString
@Sheet("Sheet1")
public class ExcelPaymentCard{

    @SheetColumn("USER")
    private String user;

    @SheetColumn("PAYMENT_DATE")
    private String paymentDate;

    @SheetColumn("CARD_COMPANY")
    private String cardCompany;

    @SheetColumn("CARD_NUMBER")
    private String cardNumber;

    @SheetColumn("STORE_NAME")
    private String storeName;

    @SheetColumn("PAYMENT_AMOUNT")
    private String paymentAmount;
}
