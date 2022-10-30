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
            strategy = GenerationType.IDENTITY
    )
    private Long idx;
    @Column(name = "user" , nullable = false)
    private String user;
    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;
    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "card_company", nullable = false)
    @Enumerated(EnumType.STRING)
    private CardCompany cardCompany;
    @Column(name = "store_name", nullable = false)
    @Enumerated(EnumType.STRING)
    private Store storeName;
    @Column(name = "payment_amount", nullable = false)
    private Long paymentAmount;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void createdAt() {
        this.createdAt = LocalDateTime.now();
    }

    @Builder
    public PaymentCard(String user, LocalDateTime paymentDate, String cardNumber, CardCompany cardCompany, Store storeName, Long paymentAmount) {
        this.user = user;
        this.cardCompany = cardCompany;
        this.cardNumber = cardNumber;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.storeName = storeName;
    }
}

