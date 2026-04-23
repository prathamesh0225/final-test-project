package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FeatureFileGenerator {

    public static void generateFeatureFile() {

        String excelPath = "src/test/resources/testdata/loginData.xlsx";
        String featurePath = "src/test/resources/features/login.feature";

        StringBuilder feature = new StringBuilder();

        feature.append("Feature: ParaBank Login Functionality\n\n");

        feature.append("  Background:\n");
        feature.append("    Given user is on the ParaBank login page \"https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC\"\n\n");

        feature.append("  Scenario Outline: Login with multiple credentials\n");
        feature.append("    When user enters username \"<username>\"\n");
        feature.append("    And user enters password \"<password>\"\n");
        feature.append("    And user clicks on login button\n");
        feature.append("    Then login should be \"<result>\"\n\n");

        feature.append("  Examples:\n");
        feature.append("    | username | password | result |\n");

        try (FileInputStream fis = new FileInputStream(excelPath);
             Workbook workbook = new XSSFWorkbook(fis);
             FileWriter writer = new FileWriter(featurePath)) {

            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < rowCount; i++) { // skip header row
                Row row = sheet.getRow(i);

                String username = getCellValue(row.getCell(0));
                String password = getCellValue(row.getCell(1));
                String result = getCellValue(row.getCell(2));

                feature.append("    | ")
                       .append(username).append(" | ")
                       .append(password).append(" | ")
                       .append(result).append(" |\n");
            }

            writer.write(feature.toString());
            System.out.println("Feature file generated successfully from Excel!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) return "";
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue().trim();
    }
}