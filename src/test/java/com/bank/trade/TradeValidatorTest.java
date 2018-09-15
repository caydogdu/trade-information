package com.bank.trade;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.bank.trade.dto.Trade;
import com.bank.trade.exception.ValidationError;
import com.bank.trade.validation.TradeValidator;

public class TradeValidatorTest {

    // If the counterparty is one of the supported ones
    @Test
    public void validateDefaultTestCounterpartyError() throws Exception {

        Trade trade = new Trade();
        trade.setCustomer("PLUTO3");
        trade.setValueDate("2018-06-13");
        trade.setTradeDate("2016-0811");
        trade.setPayCcy("USD");

        TradeValidator validator = Mockito.mock(TradeValidator.class, Mockito.CALLS_REAL_METHODS);
        List<ValidationError> errors = validator.validateDefault(trade);
        assertEquals(1, errors.size());

    }

    // Validate currencies if they are valid ISO codes (ISO 4217)
    @Test
    public void validateDefaultTestCurrencyError() throws Exception {

        Trade trade = new Trade();
        trade.setCustomer("PLUTO1");
        trade.setValueDate("2018-06-13");
        trade.setTradeDate("2016-0811");
        trade.setPayCcy("USD1");

        TradeValidator validator = Mockito.mock(TradeValidator.class, Mockito.CALLS_REAL_METHODS);
        List<ValidationError> errors = validator.validateDefault(trade);
        assertEquals(1, errors.size());

    }

    @Test
    public void validateDefaultTestNoError() throws Exception {

        Trade trade = new Trade();
        trade.setCustomer("PLUTO1");
        trade.setValueDate("2018-06-13");
        trade.setTradeDate("2016-0811");
        trade.setPayCcy("USD");

        TradeValidator validator = Mockito.mock(TradeValidator.class, Mockito.CALLS_REAL_METHODS);
        List<ValidationError> errors = validator.validateDefault(trade);
        assertEquals(0, errors.size());

    }

    // Value date cannot be before trade date
    @Test
    public void validateDefaultTestValueDateError() throws Exception {

        Trade trade = new Trade();
        trade.setCustomer("PLUTO1");
        trade.setValueDate("2015-06-12");
        trade.setTradeDate("2016-0811");
        trade.setPayCcy("USD");

        TradeValidator validator = Mockito.mock(TradeValidator.class, Mockito.CALLS_REAL_METHODS);
        List<ValidationError> errors = validator.validateDefault(trade);
        assertEquals(1, errors.size());

    }

    // Value date cannot fall on weekend or non-working day for currency
    @Test
    public void validateDefaultTestValueDateWeekendError() throws Exception {

        Trade trade = new Trade();
        trade.setCustomer("PLUTO1");
        trade.setValueDate("2018-09-15");
        trade.setTradeDate("2016-0811");
        trade.setPayCcy("USD");

        TradeValidator validator = Mockito.mock(TradeValidator.class, Mockito.CALLS_REAL_METHODS);
        List<ValidationError> errors = validator.validateDefault(trade);
        assertEquals(1, errors.size());

    }

}
