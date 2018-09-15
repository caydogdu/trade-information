package com.bank.trade;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.bank.trade.dto.Trade;
import com.bank.trade.exception.ValidationError;
import com.bank.trade.validation.SpotValidator;
import com.bank.trade.validation.TradeValidator;

public class SpotValidatorTest {

    @Test
    public void validateTestNoError() throws Exception {

        Trade trade = new Trade();
        trade.setCustomer("PLUTO1");
        trade.setValueDate("2018-06-13");
        trade.setTradeDate("2016-0811");
        trade.setPayCcy("USD");

        TradeValidator validator = new SpotValidator();
        List<ValidationError> errors = validator.validate(trade);
        assertEquals(0, errors.size());

    }

}
