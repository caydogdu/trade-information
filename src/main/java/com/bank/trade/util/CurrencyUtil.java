package com.bank.trade.util;

import java.util.Currency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CurrencyUtil {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyUtil.class);

    public static Currency getCurrency(String currency) {
        Currency ccy = null;
        try {
            ccy = Currency.getInstance(currency);
        } catch (Exception e) {
            logger.error("Error", e);
        }
        return ccy;
    }

}
