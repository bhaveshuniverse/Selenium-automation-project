package pageobject;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FlipkartHomePage extends BaseCode {
    public static void searchProduct() {
        try {
            String product = stringToPass(properties.getProperty("product"));
            driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.chord(product, Keys.ENTER));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveMobilePhonesList() throws IOException {
        try {
            //initializing list of elements
            WebElement mobile = driver.findElement(By.xpath("//div[@class='_36fx1h _6t1WkM _3HqJxg']//div[@class='_1YokD2 _3Mn1Gg']"));
            List<WebElement> mobNames = mobile.findElements(By.xpath("//div[@class='_4rR01T']"));
            List<WebElement> specifications = mobile.findElements(By.xpath("//ul[@class='_1xgFaf']"));
            List<WebElement> price = mobile.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));

            //initalizing list to store string values
            List<String> mobileNames = new ArrayList<>();

            List<List<String>> specsList = new ArrayList<>();
            List<String> priceList = new ArrayList<>();

            //adding elements value to list
            for (WebElement mn : mobNames) {
                mobileNames.add(mn.getText());
            }

            for (WebElement specs : specifications) {
                List<String> mobilespec = new ArrayList<>();
                List<WebElement> l1 = specs.findElements(By.xpath("//li[@class='rgWa7D']"));
                for (WebElement we : l1) {
                    mobilespec.add(we.getText());
                }
                specsList.add(mobilespec);
            }

            for (WebElement w : price) {
                priceList.add(w.getText());
            }

            //storing in excel file
            FileInputStream fis = new FileInputStream(new File("src/main/resources/excelfiles/MobilePhones.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("MobilesList");

            for (int i = 0; i < mobileNames.size(); i++) {
                Row newRow = sheet.createRow(i);
                newRow.createCell(0, CellType.STRING).setCellValue(mobileNames.get(i));
                newRow.createCell(1, CellType.STRING).setCellValue(specsList.get(i).toString());
                newRow.createCell(2, CellType.STRING).setCellValue(priceList.get(i));
            }

            FileOutputStream fos = new FileOutputStream(new File("src/main/resources/excelfiles/MobilePhones.xlsx"));
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
