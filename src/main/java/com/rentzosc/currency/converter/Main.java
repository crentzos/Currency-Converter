package com.rentzosc.currency.converter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> currencyRates = new HashMap<>();
        String currencyPair;
        Converter converter = new Converter();
        double convertedAmount;
        ReadExcelFile readExcelFile = new ReadExcelFile();

        currencyRates = readExcelFile.getExcelFile();

        System.out.print("Enter amount you wish to convert: ");
        double amountInput = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Select the input currency: ");
        String  inputCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the output currency: ");
        String  outputCurrency = scanner.nextLine().toUpperCase();

        currencyPair = inputCurrency + "_TO_" + outputCurrency;

        convertedAmount = converter.getConvertedAmount(amountInput, currencyPair, currencyRates);

        System.out.print(amountInput + inputCurrency + " is equal to " + convertedAmount + outputCurrency);




    }
}