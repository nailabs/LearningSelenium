package com.automation.tests.day25_excel_io;

import com.automation.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Map;

public class ReadDataFromExcel {

    @Test
    public void readExcelFileTest() throws Exception {
        File file = new File("VytrackTestUsers.xlsx"); //getting file as an object
        Workbook workbook = WorkbookFactory.create(file); //specifically excel obj
        Sheet workSheet = workbook.getSheet("QA1-short");
        Row firstRow = workSheet.getRow(0);
        Cell firstCell = firstRow.getCell(0);

        String value = firstCell.getStringCellValue();
        String secondCellValue = firstRow.getCell(1).getStringCellValue();

        System.out.println("This is 1:1 " + value);
        System.out.println("This is 1:2 " + secondCellValue);

        int lastcell = firstRow.getLastCellNum();
        System.out.println("###################");
        for (int i = 0; i < lastcell; i++) {
            System.out.print(firstRow.getCell(i) + " | ");
        }

        int numberOfRows = workSheet.getLastRowNum() + 1;
        int numberofRows2 = workSheet.getPhysicalNumberOfRows();
        System.out.println();
        System.out.println(numberOfRows);
        System.out.println(numberofRows2);

        for (int row = 0; row < workSheet.getPhysicalNumberOfRows(); row++) {
            for (int cell = 0; cell < workSheet.getRow(row).getLastCellNum(); cell++) {
                String cellValue = workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.println(cellValue + " | ");
            }
            System.out.println();
        }
    }

    @Test
    public void excelUtilityTest() {
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA1-all";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);
        //excelUtil.getDataList().forEach(p -> System.out.println(p));
        //excelUtil.getDataList().forEach(System.out::println);

        for (Map<String, String> record : excelUtil.getDataList()) {//same as line 52
                System.out.println(record);
        }
    }

    @Test
    public void getColumnNamesTest(){
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA1-short";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);
        System.out.println(excelUtil.getColumnsNames());
    }

}

