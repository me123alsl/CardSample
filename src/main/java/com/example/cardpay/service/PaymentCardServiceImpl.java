package com.example.cardpay.service;

import com.example.cardpay.entity.dao.CardCompany;
import com.example.cardpay.entity.dao.Store;
import com.example.cardpay.entity.dto.CommonResponse;
import com.example.cardpay.entity.dao.PaymentCard;
import com.example.cardpay.entity.dto.CreatePaymentRequest;
import com.example.cardpay.entity.dto.SearchPaymentRequest;
import com.example.cardpay.entity.status.RestApiErrorCode;
import com.example.cardpay.excetpion.RestApiException;
import com.example.cardpay.repository.PaymentCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentCardServiceImpl implements PaymentCardService {
    @Autowired
    private final PaymentCardRepository paymentCardRepository;

    public PaymentCardServiceImpl(PaymentCardRepository paymentCardRepository) {
        this.paymentCardRepository = paymentCardRepository;
    }

    @Override
    public CommonResponse insertCardPayment(CreatePaymentRequest createPaymentRequest) {
        PaymentCard paymentCard = paymentCardRepository.save(
                PaymentCard.builder()
                        .user(createPaymentRequest.getUser())
                        .paymentDate(createPaymentRequest.getPaymentDate())
                        .cardNumber(createPaymentRequest.getCardNumber())
                        .cardCompany(validateCardCompany(createPaymentRequest.getCardCompany()))
                        .storeName(validateStore(createPaymentRequest.getStoreName()))
                        .paymentAmount(createPaymentRequest.getPaymentAmount())
                        .build()
        );
        return CommonResponse.builder()
                .statusCode(200)
                .data(paymentCard)
                .message("결제 정보가 등록되었습니다.")
                .build();
    }

    @Override
    public CommonResponse findBySearchOption(SearchPaymentRequest searchOption) {
        List<Store> storeList = new ArrayList<>();
        List<CardCompany> cardCompanyList = new ArrayList<>();

        searchOption.getCardCompany().stream().forEach(cardCompany -> cardCompanyList.add(validateCardCompany(cardCompany)));
        searchOption.getStoreName().stream().forEach(storeName -> storeList.add(validateStore(storeName)));

        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (searchOption.getFromDate() == null) {
            searchOption.setFromDate(LocalDateTime.parse("1000-01-01 00:00:00", dateTimeFormat));
        }

        if (searchOption.getToDate() == null) {
            searchOption.setToDate(LocalDateTime.parse("9999-12-31 23:59:59", dateTimeFormat));
        }

        PageRequest pageRequest = PageRequest.of(searchOption.getPageIndex(), searchOption.getPageSize());
        Page<PaymentCard> paymentCardPage = paymentCardRepository.findBySearchOption(
                searchOption.getUser(),
                cardCompanyList,
                storeList,
                searchOption.getFromDate(),
                searchOption.getToDate(),
                pageRequest);

        if(paymentCardPage.getContent().isEmpty()) {
            throw new RestApiException(RestApiErrorCode.RESOURCE_NOT_FOUND);
        }
        return CommonResponse.builder()
                .statusCode(200)
                .data(paymentCardPage.getContent())
                .build();
    }

    //TODO: ERROR Enum Binding...
//    @Override
//    public CommonResponse findBySearchOption(SearchPaymentRequest searchOption) {

//        searchOption.getCardCompany().stream().forEach(cardCompany -> validateCardCompany(cardCompany));
//        searchOption.getStoreName().stream().forEach(storeName -> validateStore(storeName));
//
//        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        if (searchOption.getFromDate() == null) {
//            searchOption.setFromDate(LocalDateTime.parse("1000-01-01 00:00:00", dateTimeFormat));
//        }
//
//        if (searchOption.getToDate() == null) {
//            searchOption.setToDate(LocalDateTime.parse("9999-12-31 23:59:59", dateTimeFormat));
//        }
//
//        PageRequest pageRequest = PageRequest.of(searchOption.getPageIndex(), searchOption.getPageSize());
//        Page<PaymentCard> paymentCardPage = paymentCardRepository.findBySearchOption(searchOption, pageRequest);
//        if(paymentCardPage.getContent().isEmpty()) {
//            throw new RestApiException(RestApiErrorCode.RESOURCE_NOT_FOUND);
//        }
//        return CommonResponse.builder()
//                .statusCode(200)
//                .data(paymentCardPage.getContent())
//                .build();
//    }

    CardCompany validateCardCompany(String cardCompany){
        try {
            return CardCompany.valueOf(cardCompany);
        }
        catch (Exception e) {
            throw new RestApiException(RestApiErrorCode.NOT_FOUND_CARD_COMPANY);
        }
    }

    Store validateStore(String storeName) throws RestApiException{
        try {
            return Store.valueOf(storeName);
        }
        catch (Exception e) {
            throw new RestApiException(RestApiErrorCode.NOT_FOUND_STORE);
        }
    }
}
