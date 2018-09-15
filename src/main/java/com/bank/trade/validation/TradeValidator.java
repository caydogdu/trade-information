package com.bank.trade.validation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

import com.bank.trade.dto.Trade;
import com.bank.trade.exception.ValidationError;
import com.bank.trade.util.CurrencyUtil;
import com.bank.trade.util.DateUtil;

public abstract class TradeValidator {

    protected static final String[] counterparties = { "PLUTO1", "PLUTO2" };

    public abstract List<ValidationError> validate(Trade trade);

    public List<ValidationError> validateDefault(Trade trade) {

        List<ValidationError> errors = new ArrayList<>();
        LocalDate valueDate = DateUtil.toLocalDateForStringDate(trade.getValueDate());

        if (valueDate != null) {
            // Value date cannot be before trade date
            if (valueDate.compareTo(DateUtil.toLocalDateForStringDate(trade.getTradeDate())) < 0) {
                errors.add(new ValidationError("ERR-01", "Value date cannot be before trade date"));
            }
            // Value date cannot fall on weekend or non-working day for currency
            if (DateUtil.isWeekend(valueDate)) {
                errors.add(new ValidationError("ERR-02",
                        "Value date cannot fall on weekend or non-working day for currency"));
            }
        }

        // If the counterparty is one of the supported ones
        if (!Arrays.asList(counterparties).contains(trade.getCustomer())) {
            errors.add(new ValidationError("ERR-03", "Counterparty should be supported"));
        }

        // Validate currencies if they are valid ISO codes (ISO 4217)
        if (trade.getPayCcy() != null) {
            Currency ccy = CurrencyUtil.getCurrency(trade.getPayCcy());
            if (ccy == null) {
                errors.add(new ValidationError("ERR-04", "PayCcy is not valid ISO code"));
            }
        }

        if (trade.getPremiumCcy() != null) {
            Currency ccy = CurrencyUtil.getCurrency(trade.getPremiumCcy());
            if (ccy == null) {
                errors.add(new ValidationError("ERR-05", "PremiumCcy is not valid ISO code"));
            }
        }

        return errors;
    }
}
