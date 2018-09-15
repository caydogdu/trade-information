package com.bank.trade;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.bank.trade.dto.Trade;
import com.bank.trade.exception.ValidationError;
import com.bank.trade.validation.TradeValidator;
import com.bank.trade.validation.VanillaOptionValidator;

public class VanillaOptionValidatorTest {

    // ExcerciseStartDate has to be after the trade date but before the expiry date
    @Test
    public void validateTestAmericanOptionError() throws Exception {

        Trade trade = new Trade();
        trade.setCustomer("PLUTO1");
        trade.setValueDate("2018-06-13");
        trade.setTradeDate("2016-0811");
        trade.setPayCcy("USD");
        trade.setStyle("AMERICAN");
        trade.setDeliveryDate("2016-08-22");
        trade.setExpiryDate("2016-0819");
        trade.setExcerciseStartDate("2016-08-10");
        trade.setPremiumDate("201608-12");

        TradeValidator validator = new VanillaOptionValidator();
        List<ValidationError> errors = validator.validate(trade);
        assertEquals(1, errors.size());

    }

    // Expiry date and premium date shall be before delivery date
    @Test
    public void validateTestdeliveryDateError() throws Exception {

        Trade trade = new Trade();
        trade.setCustomer("PLUTO1");
        trade.setValueDate("2018-06-13");
        trade.setTradeDate("2016-0811");
        trade.setPayCcy("USD");
        trade.setStyle("AMERICAN");
        trade.setDeliveryDate("2016-08-22");
        trade.setExpiryDate("2016-0823");
        trade.setExcerciseStartDate("2016-08-12");
        trade.setPremiumDate("201608-12");

        TradeValidator validator = new VanillaOptionValidator();
        List<ValidationError> errors = validator.validate(trade);
        assertEquals(1, errors.size());

    }

    @Test
    public void validateTestNoError() throws Exception {

        Trade trade = new Trade();
        trade.setCustomer("PLUTO1");
        trade.setValueDate("2018-06-13");
        trade.setTradeDate("2016-0811");
        trade.setPayCcy("USD");
        trade.setStyle("EUROPEAN");
        trade.setDeliveryDate("2016-08-22");
        trade.setExpiryDate("2016-0819");
        trade.setExcerciseStartDate("2016-08-12");
        trade.setPremiumDate("201608-12");

        TradeValidator validator = new VanillaOptionValidator();
        List<ValidationError> errors = validator.validate(trade);
        assertEquals(0, errors.size());

    }

    // The style can be either American or European
    @Test
    public void validateTestStyleError() throws Exception {

        Trade trade = new Trade();
        trade.setCustomer("PLUTO1");
        trade.setValueDate("2018-06-13");
        trade.setTradeDate("2016-0811");
        trade.setPayCcy("USD");
        trade.setStyle("EUROPEANX");
        trade.setDeliveryDate("2016-08-22");
        trade.setExpiryDate("2016-0819");
        trade.setExcerciseStartDate("2016-08-12");
        trade.setPremiumDate("201608-12");

        TradeValidator validator = new VanillaOptionValidator();
        List<ValidationError> errors = validator.validate(trade);
        assertEquals(1, errors.size());

    }

}
