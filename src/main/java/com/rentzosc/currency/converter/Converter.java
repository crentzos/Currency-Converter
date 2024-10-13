package com.rentzosc.currency.converter;

import java.util.Map;

public class Converter {
    public double getConvertedAmount(Double amountInput, String currencyPair
            , Map<String, Double> currencyRates) {

        return currencyRates.get(currencyPair) * amountInput;
    }
}