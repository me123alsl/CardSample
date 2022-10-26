package com.example.cardpay.entity.dao;


import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "PaymentCardBuilder")
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
    private String paymentDate;
    @Column(name = "card_company", nullable = false)
    private String cardNumber;
    @Column(name = "card_company", nullable = false)
    private String cardCompany;
    @Column(name = "store_name", nullable = false)
    private String storeName;
    @Column(name = "payment_amount", nullable = false)
    private int paymentAmount;

    public static PaymentCardBuilder builder(PaymentCard PaymentCard) {
        return PaymentCardBuilder()
                .user(PaymentCard.getUser())
                .paymentDate(PaymentCard.getPaymentDate())
                .cardNumber(PaymentCard.getCardNumber())
                .cardCompany(PaymentCard.getCardCompany())
                .storeName(PaymentCard.getStoreName())
                .paymentAmount(PaymentCard.getPaymentAmount());
    }
}

