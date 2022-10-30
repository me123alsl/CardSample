package com.example.cardpay.entity.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public enum CardCompany {
    우리카드("우리카드"),
    카카오("카카오"),
    현대카드("현대카드"),
    토스("토스"),
    농협카드("농협카드"),
    신한카드("신한카드"),
    BC카드("BC카드"),
    하나카드("하나카드"),
    국민카드("국민카드")
    ;
    private String cardCompany;

    CardCompany(String cardCompany) {
        this.cardCompany = cardCompany;
    }

}
