package com.example.cardpay.entity.dao;


import lombok.*;

import javax.persistence.*;



public enum Store {
    현대백화점("현대백화점"),
    CU("CU"),
    켈빈클라인("켈빈클라인"),
    스타벅스("스타벅스"),
    짱pc("짱pc"),
    이마트("이마트"),
    코스트코("코스트코"),
    베스킨라빈스("베스킨라빈스"),
    주노헤어("주노헤어"),
    김밥천국("김밥천국"),
    교보문고("교보문고"),
    롯데아울렛("롯데아울렛"),
    빕스("빕스"),
    빽다방("빽다방"),
    롯데백화점("롯데백화점");

    private String storeName;

    Store(String storeName) {
        this.storeName = storeName;
    }

}
