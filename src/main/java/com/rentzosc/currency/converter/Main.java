package com.rentzosc.currency.converter;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        double inputAmount = 0;
        String inputCurrency = "";
        String outputCurrency = "";
        double convertedAmount = 0;
        String inputFileLocation = "";


        ExchangeRates exchangeRates = new ExchangeRates();
        Converter converter = new Converter();
        ReadExcelFile readExcelFile = new ReadExcelFile();
        WriteExcelFile writeExcelFile = new WriteExcelFile();
        List<Double> excelValues;
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

            System.out.println("Enter file path you wish to convert.");
            inputFileLocation = scanner.nextLine();
            if (inputFileLocation.isEmpty()) {
                System.out.println("Invalid file path. Please try again.");
                continue;
            }

            File file = new File(inputFileLocation);
            if(!file.exists() || !inputFileLocation.endsWith(".xlsx")) {
                System.out.println("File does not exist. Please try again.");
                continue;
            }

            break;
        }

        excelValues = readExcelFile.getValues(inputFileLocation);
        for (int i=0; i<excelValues.size(); i++) {
            convertedAmount = converter.getConvertedAmount(excelValues.get(i), inputCurrency, outputCurrency);
            writeExcelFile.insertToExcelFile(inputCurrency);

        }

        convertedAmount = converter.getConvertedAmount(inputAmount,inputCurrency, outputCurrency);

        System.out.printf("%.2f %s = %.2f %s%n", inputAmount, inputCurrency, convertedAmount, outputCurrency);

    }
}