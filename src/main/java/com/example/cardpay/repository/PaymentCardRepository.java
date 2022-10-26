package com.example.cardpay.repository;

import com.example.cardpay.entity.dto.SearchPaymentRequest;
import com.example.cardpay.entity.dao.PaymentCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentCardRepository extends JpaRepository<PaymentCard, Long> {

    PaymentCard save(PaymentCard paymentCard);

    Page<PaymentCard> findBySearchOption(SearchPaymentRequest searchOption, Pageable pageable);

}
