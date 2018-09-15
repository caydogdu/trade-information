package com.bank.trade.service;

import java.util.List;

import com.bank.trade.dto.Product;

public interface ValidationService {

    Product validate(Product product);

    List<Product> validateAll(List<? extends Product> products);

}
