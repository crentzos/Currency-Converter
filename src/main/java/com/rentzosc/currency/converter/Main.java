package com.rentzosc.currency.converter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> currencyRates = new HashMap<>();
        String conversionSelector;
        Converter converter = new Converter();
        double convertedAmount;

        System.out.print("Enter amount you wish to convert: ");
        double amountInput = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Select the input currency: ");
        String  inputCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the output currency: ");
        String  outputCurrency = scanner.nextLine().toUpperCase();

        conversionSelector = inputCurrency + "_TO_" + outputCurrency;

        convertedAmount = converter.getConvertedAmount(amountInput, conversionSelector, currencyRates);

        System.out.print(amountInput + inputCurrency + " is equal to " + convertedAmount + outputCurrency);
    }
}