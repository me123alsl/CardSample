package com.example.cardpay;

import com.example.cardpay.entity.dao.CardCompany;
import com.example.cardpay.entity.dao.PaymentCard;
import com.example.cardpay.entity.dao.Store;
import com.example.cardpay.entity.dto.ExcelPaymentCard;
import com.example.cardpay.repository.PaymentCardRepository;
import io.github.millij.poi.SpreadsheetReadException;
import io.github.millij.poi.ss.reader.XlsxReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Component
@Slf4j
public class PreRunner implements ApplicationRunner {
    @Autowired
    private PaymentCardRepository paymentCardRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String excelFilePath = Objects.requireNonNull(
                this.getClass().getClassLoader().getResource("excel/payment_card.xlsx")
        ).getPath();

        long count = paymentCardRepository.count();
        if (count == 0) {
            log.info("PaymentCardRepository is empty");
            savePreData(
                parsingExcelFile(excelFilePath)
            );
        } else {
            log.info("PaymentCardRepository is not empty : {}", count);
        }
    }

    public List<ExcelPaymentCard> parsingExcelFile(String excelFilePath) throws SpreadsheetReadException {
        final File presetFile = new File(excelFilePath);
        final XlsxReader reader = new XlsxReader();
        return reader.read(ExcelPaymentCard.class, presetFile);
    }

    @Transactional
    public void savePreData(List<ExcelPaymentCard> payments) {
        Stream<ExcelPaymentCard> paymentStream = payments.stream();
        paymentStream.forEach(payment -> {
            log.info("payment : {}", payment.toString());
            paymentCardRepository.save(
                PaymentCard.builder()
                    .user(payment.getUser())
                    .paymentDate(
                            LocalDateTime.parse(
                                    payment.getPaymentDate(),
                                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                            )
                    )
                    .cardCompany(CardCompany.valueOf(payment.getCardCompany()))
                    .cardNumber(payment.getCardNumber())
                    .storeName(Store.valueOf(payment.getStoreName()))
                    .paymentAmount(Long.parseLong(payment.getPaymentAmount().replace(",","")))
                    .build()
            );
        });
    }
}
