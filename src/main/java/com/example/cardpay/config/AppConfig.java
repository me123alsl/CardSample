package com.example.cardpay.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.example.cardpay")
@EnableJpaRepositories(basePackages = "com.example.cardpay.repository")
public class AppConfig {
}
