package com.example.cardpay.entity.dao;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "StoreBuilder")
@Table(name = "store")
public class Store {
    @Id
    @Column(name = "store_name", nullable = false, unique = true)
    private String storeName;

    public static StoreBuilder builder(Store store) {
        return StoreBuilder()
                .storeName(store.getStoreName());
    }
}
