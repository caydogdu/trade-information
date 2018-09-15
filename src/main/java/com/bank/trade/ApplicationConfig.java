package com.bank.trade;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.bank.trade.service" })
public class ApplicationConfig {
}
