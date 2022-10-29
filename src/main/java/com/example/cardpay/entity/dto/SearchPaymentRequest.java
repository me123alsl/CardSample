package com.example.cardpay.entity.dto;

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
    private LocalDateTime fromDate = LocalDateTime.of(1000, 1 ,1, 00,00,00); // 검색기간 범위 시작
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime toDate = LocalDateTime.of(3000, 12 ,31, 23,59,59);   // 검색기간 범위 종료
    private List<String> cardCompany;
    private List<String> storeName;
    private int pageIndex;  // 화면 하단 페이지의 인덱스
    private int pageSize;   // 화면에 표시한 데이터 수
}
