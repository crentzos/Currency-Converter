package com.rentzosc.currency.converter;

public class UserInputData {
    private double inputAmount;
    private String inputCurrency;
    private String outputCurrency;
    private String inputFileLocation;
    private String outputFileLocation;
    private boolean singleValueConversion;


    public UserInputData(double inputAmount, String inputCurrency, String outputCurrency, String inputFileLocation,
                         String outputFileLocation, boolean singleValueConversion) {
        this.inputAmount = inputAmount;
        this.inputCurrency = inputCurrency;
        this.outputCurrency = outputCurrency;
        this.inputFileLocation = inputFileLocation;
        this.outputFileLocation = outputFileLocation;
        this.singleValueConversion = singleValueConversion;
    }

    public UserInputData() {
    }

    public double getInputAmount() {
        return inputAmount;
    }

    public void setInputAmount(double inputAmount) {
        this.inputAmount = inputAmount;
    }

    public String getInputCurrency() {
        return inputCurrency;
    }

    public void setInputCurrency(String inputCurrency) {
        this.inputCurrency = inputCurrency;
    }

    public String getOutputCurrency() {
        return outputCurrency;
    }

    public void setOutputCurrency(String outputCurrency) {
        this.outputCurrency = outputCurrency;
    }

    public String getInputFileLocation() {
        return inputFileLocation;
    }

    public void setInputFileLocation(String inputFileLocation) {
        this.inputFileLocation = inputFileLocation;
    }

    public String getOutputFileLocation() {
        return outputFileLocation;
    }

    public void setOutputFileLocation(String outputFileLocation) {
        this.outputFileLocation = outputFileLocation;
    }

    public boolean isSingleValueConversion() {
        return singleValueConversion;
    }

    public void setSingleValueConversion(boolean singleValueConversion) {
        this.singleValueConversion = singleValueConversion;
    }
}
