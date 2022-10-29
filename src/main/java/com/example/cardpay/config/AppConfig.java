package com.example.cardpay.config;

import com.example.cardpay.repository.PaymentCardRepository;
import com.example.cardpay.service.PaymentCardService;
import com.example.cardpay.service.PaymentCardServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.example.cardpay")
@EnableJpaRepositories(basePackages = "com.example.cardpay.repository")
public class AppConfig {

}
