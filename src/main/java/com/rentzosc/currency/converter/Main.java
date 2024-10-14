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
        /* String fileLocation = "C:\\Users\\Christos\\Desktop\\Web Developer\\Mini " +
                "Projects\\Currency-Converter\\currency_exchange_rates.xlsx"; */ // Desktop

        String fileLocation = "C:\\Users\\RentzosC\\Desktop\\Web Developer\\Mini Projects\\Currency-Converter\\currency_exchange_rates.xlsx"; // Laptop
        ReadExcelFile readExcelFile = new ReadExcelFile();

        currencyRates = readExcelFile.getExcelFile(fileLocation);

        System.out.println(currencyRates);

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