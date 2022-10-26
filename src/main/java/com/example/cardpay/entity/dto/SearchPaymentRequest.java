package com.example.cardpay.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class SearchPaymentRequest {
    private String user;
    private LocalDateTime fromDate; // 검색기간 범위 시작
    private LocalDateTime toDate;   // 검색기간 범위 종료
    private int pageIndex;  // 화면 하단 페이지의 인덱스
    private int pageSize;   // 화면에 표시한 데이터 수
    private List<String> cardCompany;
    private List<String> storeName;
}
