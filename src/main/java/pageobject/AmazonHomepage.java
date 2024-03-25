package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.IOException;

public class AmazonHomepage extends BaseCode {

    public static void navigatToLoginPage() {
        try {
            driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void searchKeyword() {
        try {
            driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.chord(stringToPass(properties.getProperty("product")), Keys.ENTER));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void openCart() throws IOException {
        try {
            browserInvocation();
            driver.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
