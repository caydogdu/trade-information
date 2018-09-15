package com.bank.trade.validation;

import java.util.ArrayList;
import java.util.List;

import com.bank.trade.dto.Trade;
import com.bank.trade.exception.ValidationError;

public class ForwardValidator extends TradeValidator {

    @Override
    public List<ValidationError> validate(Trade trade) {
        List<ValidationError> errors = new ArrayList<>();
        errors.addAll(validateDefault(trade));
        return errors;
    }

}
