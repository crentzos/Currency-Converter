package com.rentzosc.currency.converter;

import java.io.IOException;
import java.util.Map;

public class Converter {
    public double getConvertedAmount(Double inputAmount, String inputCurrency, String outputCurrency) throws IOException, InterruptedException {

        ExchangeRates exchangeRates = new ExchangeRates();
        Map<String, Double> currencyRates = exchangeRates.getLatestExchangeRates();

        double amountInEur = inputAmount / currencyRates.get(inputCurrency);

        return amountInEur * currencyRates.get(outputCurrency);
    }
}