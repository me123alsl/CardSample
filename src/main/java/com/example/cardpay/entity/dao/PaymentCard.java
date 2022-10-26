package com.example.cardpay.entity.dao;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "payment_card")
public class PaymentCard {
    @Id
    @Column(name = "idx")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "PAYMENT_CARD_SEQ_GENERATOR"
    )
    private Long idx;

    @Column(name = "user" , nullable = false)
    private String user;
    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;
    @Column(name = "card_number", nullable = false)
    private String cardNumber;
    @Column(name = "card_company", nullable = false)
    private String cardCompany;
    @Column(name = "store_name", nullable = false)
    private String storeName;
    @Column(name = "payment_amount", nullable = false)
    private int paymentAmount;

    @Builder
    public PaymentCard(String user, LocalDateTime paymentDate, String cardNumber, String cardCompany, String storeName, int paymentAmount) {
        this.user = user;
        this.cardCompany = cardCompany;
        this.cardNumber = cardNumber;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.storeName = storeName;
    }
}

