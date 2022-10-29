package com.example.cardpay.repository;

import com.example.cardpay.entity.dao.PaymentCard;
import com.example.cardpay.entity.dto.SearchPaymentRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentCardRepository extends JpaRepository<PaymentCard, Long> {

    PaymentCard save(PaymentCard paymentCard);

    @Query(value = "SELECT pc FROM PaymentCard pc "
            + "WHERE "
            + "pc.user = :#{#searchOption.user} "
            + "AND pc.cardCompany IN :#{#searchOption.cardCompany} "
            + "AND pc.storeName IN  :#{#searchOption.storeName} "
            + "AND pc.paymentDate between :#{#searchOption.fromDate} and :#{#searchOption.toDate}"
    )
    Page<PaymentCard> findBySearchOption(@Param("searchOption") SearchPaymentRequest searchOption, Pageable pageRequest);

}
