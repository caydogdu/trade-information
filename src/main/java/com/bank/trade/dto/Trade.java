package com.bank.trade.dto;

import java.math.BigDecimal;
import java.util.List;

import com.bank.trade.exception.ValidationError;
import com.bank.trade.validation.TradeValidator;
import com.bank.trade.validation.TradeValidatorFactory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Trade implements Product {

    private String customer;

    private String ccyPair;

    private String type;

    private String style;

    private String direction;

    private String strategy;

    private String tradeDate;

    private BigDecimal amount1;

    private BigDecimal amount2;

    private double rate;

    private String valueDate;

    private String deliveryDate;

    private String expiryDate;

    private String excerciseStartDate;

    private String payCcy;

    private double premium;

    private String premiumCcy;

    private String premiumType;

    private String premiumDate;

    private String legalEntity;

    private String trader;

    @JsonIgnore
    private TradeValidator validator;

    private List<ValidationError> validationErrors;

    public BigDecimal getAmount1() {
        return amount1;
    }

    public BigDecimal getAmount2() {
        return amount2;
    }

    public String getCcyPair() {
        return ccyPair;
    }

    public String getCustomer() {
        return customer;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getDirection() {
        return direction;
    }

    public String getExcerciseStartDate() {
        return excerciseStartDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getLegalEntity() {
        return legalEntity;
    }

    public String getPayCcy() {
        return payCcy;
    }

    public double getPremium() {
        return premium;
    }

    public String getPremiumCcy() {
        return premiumCcy;
    }

    public String getPremiumDate() {
        return premiumDate;
    }

    public String getPremiumType() {
        return premiumType;
    }

    public double getRate() {
        return rate;
    }

    public String getStrategy() {
        return strategy;
    }

    public String getStyle() {
        return style;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public String getTrader() {
        return trader;
    }

    public String getType() {
        return type;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public TradeValidator getValidator() {
        return validator;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setAmount1(BigDecimal amount1) {
        this.amount1 = amount1;
    }

    public void setAmount2(BigDecimal amount2) {
        this.amount2 = amount2;
    }

    public void setCcyPair(String ccyPair) {
        this.ccyPair = ccyPair;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setExcerciseStartDate(String excerciseStartDate) {
        this.excerciseStartDate = excerciseStartDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setLegalEntity(String legalEntity) {
        this.legalEntity = legalEntity;
    }

    public void setPayCcy(String payCcy) {
        this.payCcy = payCcy;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public void setPremiumCcy(String premiumCcy) {
        this.premiumCcy = premiumCcy;
    }

    public void setPremiumDate(String premiumDate) {
        this.premiumDate = premiumDate;
    }

    public void setPremiumType(String premiumType) {
        this.premiumType = premiumType;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValidationErrors(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public void setValidator(TradeValidator validator) {
        this.validator = validator;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    @Override
    public void validate() {
        setValidator(TradeValidatorFactory.getInstance(type));
        setValidationErrors(validator.validate(this));
    }

}
