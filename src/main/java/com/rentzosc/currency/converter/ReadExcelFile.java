package com.rentzosc.currency.converter;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcelFile {

    public Map<String, Double> getExcelFile(String fileLocation) throws IOException {
        FileInputStream file = new FileInputStream(new File(fileLocation));
        Workbook workbook = new XSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);
        Map<String, Double> currencyExchangeRates = new HashMap<String, Double>();

        for (Row row : sheet) {
            if (row == null || row.getCell(0) == null || row.getCell(1) == null) {
                continue;
            }
                String currencyPair = null;
                Double currencyRate = null;

                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.BLANK || cell == null ) {
                        break;
                    }

                    int colIndex = cell.getColumnIndex();
                    if (colIndex == 0 && cell.getCellType() == CellType.STRING) {
                        currencyPair = cell.getStringCellValue();
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        currencyRate = cell.getNumericCellValue();
                    }
                }
                if (currencyPair != null && currencyRate !=null) {
                    currencyExchangeRates.put(currencyPair, currencyRate);
                }
            }

        workbook.close();
        file.close();

        return currencyExchangeRates;
        }
    }
