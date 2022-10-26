package com.example.cardpay.repository;

import com.example.cardpay.entity.dto.SearchPaymentRequest;
import com.example.cardpay.entity.dao.PaymentCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentCardRepository extends JpaRepository<PaymentCard, Long> {

    PaymentCard save(PaymentCard paymentCard);

    @Query(value = "" +
            "SELECT pc " +
            "FROM payment_card as pc" +
            "WHERE " +
            "user = :#{#searchOption.user} " +
            "AND card_company IN :#{#searchOption.cardCompany} " +
            "AND store_name IN :#{#searchOption.storeName} " +
            "AND payment_date BETWEEN :#{#searchOption.fromDate} " +
            "AND :#{#searchOption.toDate}", nativeQuery = true
    )
    Page<PaymentCard> findBySearchOption(SearchPaymentRequest searchOption, PageRequest pageRequest);

}
