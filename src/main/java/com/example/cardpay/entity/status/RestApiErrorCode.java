package com.example.cardpay.entity.status;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@RequiredArgsConstructor
public enum RestApiErrorCode implements ErrorCode{
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "등록된 결제정보가 없습니다."),
    NOT_FOUND_STORE(HttpStatus.NOT_FOUND, "등록된 스토어정보가 없습니다."),
    NOT_FOUND_CARD_COMPANY(HttpStatus.NOT_FOUND, "등록된 카드사가 없습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
