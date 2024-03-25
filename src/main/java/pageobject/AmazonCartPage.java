package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AmazonCartPage extends BaseCode {
    public static void increaseToQuantity(String n) {
        try {
            Select qty = new Select(driver.findElement(By.xpath("//select[@name='quantity']")));
            qty.selectByValue(n);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void proceedToCheckout() {

        try {
            driver.findElement(By.name("proceedToRetailCheckout")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean validatePage() {
        try {
            return driver.findElement(By.xpath("//h1[normalize-space(text())='Checkout']")).getText().equals("Checkout");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
