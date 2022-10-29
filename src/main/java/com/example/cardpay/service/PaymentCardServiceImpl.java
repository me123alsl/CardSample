package com.example.cardpay.service;

import com.example.cardpay.entity.CommonResponse;
import com.example.cardpay.entity.dao.PaymentCard;
import com.example.cardpay.entity.dto.CreatePaymentRequest;
import com.example.cardpay.entity.dto.SearchPaymentRequest;
import com.example.cardpay.repository.PaymentCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PaymentCardServiceImpl implements PaymentCardService {
    @Autowired
    private final PaymentCardRepository paymentCardRepository;

    public PaymentCardServiceImpl(PaymentCardRepository paymentCardRepository) {
        this.paymentCardRepository = paymentCardRepository;
    }

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
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (searchOption.getToDate() == null) {
            searchOption.setToDate(LocalDateTime.parse("1000-01-01 00:00:00", dateTimeFormat));
        }
        if (searchOption.getFromDate() == null) {
            searchOption.setToDate(LocalDateTime.parse("9999-12-31 23:59:59", dateTimeFormat));
        }
        PageRequest pageRequest = PageRequest.of(searchOption.getPageIndex(), searchOption.getPageSize());
        Page<PaymentCard> paymentCardPage = paymentCardRepository.findBySearchOption(searchOption, pageRequest);
        return CommonResponse.builder()
                .statusCode(200)
                .data(paymentCardPage.getContent())
                .build();
    }
}
