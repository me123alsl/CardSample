package com.example.cardpay.service;

import com.example.cardpay.entity.ResponseDTO;
import com.example.cardpay.entity.StatusCode;
import com.example.cardpay.entity.dao.PaymentCard;
import com.example.cardpay.entity.dto.SearchPaymentRequest;
import com.example.cardpay.repository.PaymentCardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PaymentCardServiceImpl implements PaymentCardService {

    private PaymentCardRepository paymentCardRepository;

    @Override
    public void insertCardPayment(PaymentCard paymentCard) {
        paymentCardRepository.save(paymentCard);
    }

    @Override
    public ResponseDTO findBySearchOption(SearchPaymentRequest searchOption) {
        Pageable pageable = PageRequest.of(searchOption.getPageIndex(), searchOption.getPageSize());
        Page<PaymentCard> paymentCardPage = paymentCardRepository.findBySearchOption(searchOption, pageable);
        return ResponseDTO.builder()
                .statusCode(200)
                .data(paymentCardPage.getContent())
//                .totalElements(paymentCardPage.getTotalElements())
                .build();
    }
}
