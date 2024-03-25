package pageobject;

import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class AmazonProductPage extends BaseCode {
    public static void selectProduct() {
        try {
            driver.findElement(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Starlight']")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void select256GB() {
        try {
//        driver.findElement(By.xpath("//p[text()='256 GB']")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addToCart() {
        try {
            applyImplicitWait(Duration.ofSeconds(10));
            waitForSomeTime(Duration.ofSeconds(100), "//div[@id='desktop_qualifiedBuyBox']//input[@id='add-to-cart-button']");
            driver.findElement(By.xpath("//div[@id='desktop_qualifiedBuyBox']//input[@id='add-to-cart-button']")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
