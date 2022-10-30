package com.example.cardpay.entity.dto;

import com.example.cardpay.entity.dao.CardCompany;
import com.example.cardpay.entity.dao.Store;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchPaymentRequest {
    private String user;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fromDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime toDate;
    private List<String> cardCompany;
    private List<String> storeName;
    private int pageIndex;  // 화면 하단 페이지의 인덱스
    private int pageSize;   // 화면에 표시한 데이터 수
}
