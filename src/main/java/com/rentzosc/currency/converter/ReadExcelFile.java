package com.rentzosc.currency.converter;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcelFile {
    String fileLocation = "C:\\Users\\RentzosC\\Documents\\currency_exchange_rates.xlsx";
    public void getExcelFile() throws IOException {
        FileInputStream file = new FileInputStream(new File(fileLocation));
        Workbook workbook = new XSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);
        Map<String, Double> currencyExchangeRates = new HashMap<String, Double>();
        int i = 0;
        for (Row row : sheet) {

        }
    }
}