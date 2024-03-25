package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonLoginPage extends BaseCode {
    public static void fillLoginCredentials() {
        try {

            //filling username and clicking on continue button
            driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(stringToPass(properties.getProperty("username")));
            driver.findElement(By.xpath("//input[@id='continue']")).click();

            //filling password
            driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(stringToPass(properties.getProperty("password")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void amazonLogin() {
        try {
        driver.findElement(By.id("signInSubmit")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isUserLoggedIn() {

        //checking the name of user logged in is correct or not
        try {
            return driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText().equals("Hello, " + stringToPass(properties.getProperty("userFirstName")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
