package util;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import static base.TestBase.driver;

public class TestUtil {

    static final private String CURRENT_DIRECTORY = System.getProperty("user.dir");

    public static String TESTDATA_SHEET_PATH = CURRENT_DIRECTORY + "\\src\\main\\java\\testdata\\FreeCRMTestData.xlsx";

    static Workbook book;
    static Sheet sheet;

    public static void elementWait(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static Object[][] getTestData(String sheetName){
        FileInputStream file = null;
        try {
            try {
                file = new FileInputStream(TESTDATA_SHEET_PATH);
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + TESTDATA_SHEET_PATH);
                e.printStackTrace();
            }

            try {
                assert file != null;
                book = WorkbookFactory.create(file);
            } catch (InvalidFormatException e) {
                System.out.println("Error creating workbook");
                e.printStackTrace();
            }
            sheet = book.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet with name " + sheetName + " not found in the Excel file.");
            }

            int lastRowNum = sheet.getLastRowNum();
            int lastCellNum = sheet.getRow(0) != null ? sheet.getRow(0).getLastCellNum() : 0;

            Object[][] data = new Object[lastRowNum][lastCellNum];
            for (int i = 1; i <= lastRowNum; i++) {//i = 1 because jump the title columns
                if (sheet.getRow(i) != null) {
                    for (int k = 0; k < lastCellNum; k++) {
                        Cell cell = sheet.getRow(i).getCell(k);
                        if (cell != null) {
                            data[i - 1][k] = cell.toString();
                        } else {
                            // Handle the case where the cell is null (e.g., set a default value)
                            System.out.println("Cell at row " + (i + 1) + " and column " + k + " is null.");
                        }
                    }
                }
            }
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void takeScreenShotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File(CURRENT_DIRECTORY + "\\screenshots\\" + System.currentTimeMillis() + ".png"));
    }

    public static void switchToFrameForIndex(int index){
        driver.switchTo().frame(index);
    }
}
