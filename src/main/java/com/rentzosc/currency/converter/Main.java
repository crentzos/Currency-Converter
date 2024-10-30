package com.rentzosc.currency.converter;


import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        Converter converter = new Converter();
        WriteExcelFile writeExcelFile = new WriteExcelFile();
        UserInput userInput = new UserInput();
        UserInputData userInputData = userInput.getUserInput();

        double inputAmount = userInputData.getInputAmount();
        String inputCurrency = userInputData.getInputCurrency();
        String outputCurrency = userInputData.getOutputCurrency();
        String inputFileLocation = userInputData.getInputFileLocation();
        String outputFileLocation = userInputData.getOutputFileLocation();

        if (userInputData.isSingleValueConversion()) {
            double convertedAmount = converter.getConvertedAmount(inputAmount,inputCurrency, outputCurrency);
            System.out.printf("%.2f %s = %.2f %s%n", inputAmount, inputCurrency, convertedAmount, outputCurrency);
        } else {
            writeExcelFile.insertToExcelFile(inputCurrency, outputCurrency, inputFileLocation, outputFileLocation);
        }
    }
}