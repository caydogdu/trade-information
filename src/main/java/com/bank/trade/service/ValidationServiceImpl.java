package com.bank.trade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.trade.dto.Product;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public Product validate(Product product) {
        product.validate();
        return product;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> validateAll(List<? extends Product> products) {
        products.forEach(pr -> pr.validate());
        return ((List<Product>) products);
    }

}
