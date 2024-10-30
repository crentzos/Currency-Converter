package com.rentzosc.currency.converter;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class UserInput {
    public UserInputData getUserInput () throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);


        ExchangeRates exchangeRates = new ExchangeRates();
        Map<String, Double> currencyRates = exchangeRates.getLatestExchangeRates();
        UserInputData userInputData = new UserInputData();



        while (true) {
            System.out.println("Enter 1 for single value conversion or anything else for multiple values from an " +
                    "Excel file:");
            int conversionType = scanner.nextInt();
            scanner.nextLine();

            userInputData.setSingleValueConversion(conversionType == 1);

            try {
                System.out.print("Enter amount you wish to convert: ");
                userInputData.setInputAmount(scanner.nextDouble());
                scanner.nextLine();
            } catch (Exception ex) {
                System.out.println("Invalid input amount. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            System.out.print("Select the input currency: ");
            userInputData.setInputCurrency(scanner.nextLine().toUpperCase());
            if(!currencyRates.containsKey(userInputData.getInputCurrency())) {
                System.out.println("Invalid currency code. Please try again.");
                continue;
            }

            System.out.print("Enter the output currency: ");
             userInputData.setOutputCurrency(scanner.nextLine().toUpperCase());
            if (!currencyRates.containsKey(userInputData.getOutputCurrency())) {
                System.out.println("Invalid currency code. Please try again.");
                continue;
            }

            if (!userInputData.isSingleValueConversion()) {
                System.out.println("Enter file path you wish to convert.");
                userInputData.setInputFileLocation(scanner.nextLine());
                if (userInputData.getInputFileLocation().isEmpty()) {
                    System.out.println("Invalid file path. Please try again.");
                    continue;
                }

                File file = new File(userInputData.getInputFileLocation());
                if (!file.exists() || !userInputData.getInputFileLocation().endsWith(".xlsx")) {
                    System.out.println("File does not exist or is not excel file. Please try again.");
                    continue;
                }

                System.out.println("Enter file path you wish the output to be stored.");
                userInputData.setOutputFileLocation(scanner.nextLine());
                if (userInputData.getOutputFileLocation().isEmpty()) {
                    System.out.println("Invalid file path. Please try again.");
                    continue;
                }

                if (!userInputData.getOutputFileLocation().endsWith(".xlsx")) {
                    System.out.println("Please select excel file");
                    continue;
                }
            }

            break;
        }

        return userInputData;
    }
}
