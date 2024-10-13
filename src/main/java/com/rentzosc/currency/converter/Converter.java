package com.rentzosc.currency.converter;

import java.util.Map;

public class Converter {
    public double getConvertedAmount(Double amountInput, String conversionSelector
            , Map<String, Double> currencyRates) {

        return currencyRates.get(conversionSelector) * amountInput;
    }
}