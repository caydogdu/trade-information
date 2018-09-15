package com.bank.trade.validation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bank.trade.dto.Trade;
import com.bank.trade.exception.ValidationError;
import com.bank.trade.util.DateUtil;

public class VanillaOptionValidator extends TradeValidator {

    protected static final String AMERICAN_OPTION = "AMERICAN";

    protected static final String EUROPEAN_OPTION = "EUROPEAN";

    protected static final String[] styles = { EUROPEAN_OPTION, AMERICAN_OPTION };

    @Override
    public List<ValidationError> validate(Trade trade) {

        List<ValidationError> errors = new ArrayList<>();
        errors.addAll(validateDefault(trade));

        // The style can be either American or European
        if (!Arrays.asList(styles).contains(trade.getStyle())) {
            errors.add(new ValidationError("ERR-06", "The style can be either American or European"));
        }

        if (AMERICAN_OPTION.equals(trade.getStyle())) {
            LocalDate excerciseStarDate = DateUtil.toLocalDateForStringDate(trade.getExcerciseStartDate());
            // ExcerciseStartDate has to be after the trade date but before the expiry date
            if (trade.getExcerciseStartDate() == null || trade.getTradeDate() == null
                    || excerciseStarDate.compareTo(DateUtil.toLocalDateForStringDate(trade.getTradeDate())) < 0
                    || excerciseStarDate.compareTo(DateUtil.toLocalDateForStringDate(trade.getExpiryDate())) > 0) {
                errors.add(new ValidationError("ERR-07",
                        "ExcerciseStartDate has to be after the trade date but before the expiry date"));
            }
        }

        LocalDate deliveryDate = DateUtil.toLocalDateForStringDate(trade.getDeliveryDate());
        // Expiry date and premium date shall be before delivery date
        if (trade.getDeliveryDate() == null || trade.getExpiryDate() == null || trade.getPremiumDate() == null
                || deliveryDate.compareTo(DateUtil.toLocalDateForStringDate(trade.getExpiryDate())) < 0
                || deliveryDate.compareTo(DateUtil.toLocalDateForStringDate(trade.getPremiumDate())) < 0) {
            errors.add(new ValidationError("ERR-08", "Expiry date and premium date shall be before delivery date"));
        }
        return errors;
    }
}
