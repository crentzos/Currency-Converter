package com.rentzosc.currency.converter;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*Scanner scanner = new Scanner(System.in);
        Map<String, Double> currencyRates = new HashMap<>();
        String currencyPair;
        Converter converter = new Converter();
        double convertedAmount;

        Set currencyKeySet = new HashSet();

        /* String fileLocation = "C:\\Users\\Christos\\Desktop\\Web Developer\\Mini " +
                "Projects\\Currency-Converter\\currency_exchange_rates.xlsx"; */ // Desktop

        String fileLocation = "C:\\Users\\RentzosC\\Desktop\\Web Developer\\Mini Projects\\Currency-Converter\\currency_exchange_rates.xlsx"; // Laptop

        ReadExcelFile readExcelFile = new ReadExcelFile();



        currencyRates = readExcelFile.getExcelFile(fileLocation);

        currencyKeySet = currencyRates.keySet();


        System.out.print("Enter amount you wish to convert: ");
        double amountInput = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Select the input currency: ");
        String  inputCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the output currency: ");
        String  outputCurrency = scanner.nextLine().toUpperCase();

        currencyPair = inputCurrency + "_TO_" + outputCurrency;

        convertedAmount = converter.getConvertedAmount(amountInput, currencyPair, currencyRates);

        System.out.print(amountInput + inputCurrency + " is equal to " + convertedAmount + outputCurrency);*/

        ApiRequest apiRequest = new ApiRequest();

        System.out.println(apiRequest.getLatestExchangeRates());


    }
}