package com.rentzosc.currency.converter;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteExcelFile {
    public static void insertToExcelFile(String inputCurrency, String outputCurrency) throws IOException, InterruptedException {
        Workbook workbook = new XSSFWorkbook();
        ReadExcelFile readExcelFile = new ReadExcelFile();
        Converter converter = new Converter();
        ExchangeRates exchangeRates = new ExchangeRates();
        List<Double> excelValues = readExcelFile.getValues("");

        double convertedAmount;
        double inputAmount;

        Sheet spreadsheet = workbook.createSheet("Converted Values");

        Map<String, Double> currencyRates = exchangeRates.getLatestExchangeRates();

        Row headerRow = spreadsheet.createRow(0);
        headerRow.createCell(0).setCellValue("Original Amount in "+ inputCurrency);
        headerRow.createCell(1).setCellValue("Converted Amount in "+ outputCurrency);

        for (int i = 0; i < excelValues.size(); i++) {
            inputAmount = excelValues.get(i);
            convertedAmount = converter.getConvertedAmount(inputAmount, inputCurrency, outputCurrency,
                    currencyRates);
            Row row = spreadsheet.createRow(i + 1);
            row.createCell(0).setCellValue(inputAmount);
            row.createCell(1).setCellValue(convertedAmount);
        }


        //save the Excel file
        try {
            FileOutputStream out = new FileOutputStream(new File("excel.xlsx"));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}