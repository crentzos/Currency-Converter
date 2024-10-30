package com.rentzosc.currency.converter;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcelFile {

    public List<Double> getValues(String fileLocation) throws IOException {
        FileInputStream file = new FileInputStream(new File(fileLocation));
        Workbook workbook = new XSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);
        List<Double> excelValues  = new ArrayList<>();

        for (Row row : sheet) {
           if (row == null) {
               continue;
           }

           Cell cell = row.getCell(0);

           if (cell != null && cell.getCellType() == CellType.NUMERIC) {
               excelValues.add(cell.getNumericCellValue());
           }
        }

        workbook.close();
        file.close();

        return excelValues;
        }
    }
