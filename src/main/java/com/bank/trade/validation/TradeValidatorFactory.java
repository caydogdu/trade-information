package com.bank.trade.validation;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TradeValidatorFactory {

    private static ConcurrentMap<String, TradeValidator> instance = new ConcurrentHashMap<>();

    private static ConcurrentMap<String, TradeValidator> generateMap() {
        instance.put("Spot", new SpotValidator());
        instance.put("Forward", new ForwardValidator());
        instance.put("VanillaOption", new VanillaOptionValidator());
        return instance;
    }

    public static TradeValidator getInstance(String type) {
        if (instance.get(type) == null) {
            generateMap();
        }
        return instance.get(type);
    }

    public ConcurrentMap<String, TradeValidator> getFactory() {
        return instance;
    }

}
