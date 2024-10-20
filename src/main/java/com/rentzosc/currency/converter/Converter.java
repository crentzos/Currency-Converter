package com.rentzosc.currency.converter;

import java.util.Map;

public class Converter {
    public double getConvertedAmount(Double inputAmount, String inputCurrency, String outputCurrency,
                                     Map<String, Double> currencyRates) {

            double amountInEur = inputAmount / currencyRates.get(inputCurrency);
            double convertedAmount = amountInEur * currencyRates.get(outputCurrency);

            return convertedAmount;
    }
}