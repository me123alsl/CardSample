package com.example.cardpay.entity.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "CardCompanyBuilder")
@Table(name = "card_company")
public class CardCompany {
    @Id
    @Column(name = "card_company", nullable = false, unique = true)
    private String cardCompany;

    public static CardCompanyBuilder builder(CardCompany cardCompany) {
        return CardCompanyBuilder()
                .cardCompany(cardCompany.getCardCompany());
    }
}