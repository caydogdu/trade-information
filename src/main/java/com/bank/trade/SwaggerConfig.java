package com.bank.trade;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo metaData() {
        return new ApiInfo("Spring Boot REST API", "Spring Boot REST API for Trade Information", "1.0",
                "Terms of service",
                new Contact("Cemil Aydogdu", "https://github.com/caydogdu", "caydogdu@innova.com.tr"),
                "Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0");
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.bank.trade.controller")).build().apiInfo(metaData());

    }
}
