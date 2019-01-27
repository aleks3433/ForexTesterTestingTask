package framework;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class XLSParser {

    public static XSSFSheet getDataFromExcel() {
        try {
            // Specify the path of file
            File actualPricesFile = new File("src/test/java/resources/ActualPrices.xlsx");

            // load file
            FileInputStream fileInputStreamActualPricesFile = new FileInputStream(actualPricesFile);

            // Load workbook
            XSSFWorkbook workbookActualPricesFile = new XSSFWorkbook(fileInputStreamActualPricesFile);

            // Load sheet
            // Here we are loading first sheetonly
            XSSFSheet firstSheetActualPricesFile = workbookActualPricesFile.getSheetAt(0);

            return firstSheetActualPricesFile;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

