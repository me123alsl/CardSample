package com.example.cardpay.service;

import com.example.cardpay.entity.CommonResponse;
import com.example.cardpay.entity.dao.PaymentCard;
import com.example.cardpay.entity.dto.CreatePaymentRequest;
import com.example.cardpay.entity.dto.SearchPaymentRequest;
import com.example.cardpay.repository.PaymentCardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentCardServiceImpl implements PaymentCardService {

    private PaymentCardRepository paymentCardRepository;

    @Override
    public void insertCardPayment(CreatePaymentRequest createPaymentRequest) {
        paymentCardRepository.save(
                PaymentCard.builder()
                .user(createPaymentRequest.getUser())
                .paymentDate(createPaymentRequest.getPaymentDate())
                .cardNumber(createPaymentRequest.getCardNumber())
                .cardCompany(createPaymentRequest.getCardCompany())
                .storeName(createPaymentRequest.getStoreName())
                .paymentAmount(createPaymentRequest.getPaymentAmount())
                .build()
        );
    }

    @Override
    public CommonResponse findBySearchOption(SearchPaymentRequest searchOption) {
        PageRequest pageRequest = PageRequest.of(searchOption.getPageIndex(), searchOption.getPageSize());
        Page<PaymentCard> paymentCardPage = paymentCardRepository.findBySearchOption(searchOption, pageRequest);
        return CommonResponse.builder()
                .statusCode(200)
                .data(paymentCardPage.getContent())
                .build();
    }
}
