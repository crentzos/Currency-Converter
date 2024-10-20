package com.rentzosc.currency.converter;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        double inputAmount = 0;
        String inputCurrency = "";
        String outputCurrency = "";
        double convertedAmount = 0;


        ExchangeRates exchangeRates = new ExchangeRates();
        Converter converter = new Converter();
        Map<String, Double> currencyRates = exchangeRates.getLatestExchangeRates();

        while (true) {
            try {
                System.out.print("Enter amount you wish to convert: ");
                inputAmount = scanner.nextDouble();
                scanner.nextLine();
            } catch (Exception ex) {
                System.out.println("Invalid input amount. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            System.out.print("Select the input currency: ");
            inputCurrency = scanner.nextLine().toUpperCase();
            if(!currencyRates.containsKey(inputCurrency)) {
                System.out.println("Invalid currency code. Please try again.");
                continue;
            }

            System.out.print("Enter the output currency: ");
            outputCurrency = scanner.nextLine().toUpperCase();

            if (!currencyRates.containsKey(outputCurrency)) {
                System.out.println("Invalid currency code. Please try again.");
                continue;
            }

            break;
        }

        convertedAmount = converter.getConvertedAmount(inputAmount,inputCurrency, outputCurrency, currencyRates);

        System.out.printf("%.2f %s = %.2f %s%n", inputAmount, inputCurrency, convertedAmount, outputCurrency);

    }
}