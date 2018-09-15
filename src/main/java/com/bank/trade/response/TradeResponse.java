package com.bank.trade.response;

import java.util.List;

import com.bank.trade.dto.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author caydogdu
 *
 *         This is a common response class for rest response
 */
@JsonInclude(value = Include.NON_NULL)
public class TradeResponse {

    private boolean success;

    private List<Product> result;

    public List<Product> getResult() {
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setResult(List<Product> result) {
        this.result = result;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}