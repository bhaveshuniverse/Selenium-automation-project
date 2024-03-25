package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

public class BaseCode {
    public static WebDriver driver;
    public static Properties properties;

    public static void browserInvocation() throws IOException {
        try {
            // loading the property file
            FileInputStream fis = new FileInputStream(new File("src/main/resources/configuration/config.properties"));
            properties = new Properties();
            properties.load(fis);

            // checking which browser to open based upon data present in property file
            String browser = stringToPass(properties.getProperty("browser"));
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else if (browser.equalsIgnoreCase("safari")) {
                driver = new SafariDriver();
            }

            // navigating to url mentioned in property file
            String url = stringToPass(properties.getProperty("url"));
            driver.navigate().to(url);

            // maximizing the window
            driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String stringToPass(String product) {
        try {
            return product.substring(1, product.length() - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void waitForSomeTime(Duration duration, String xpath) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, duration);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='desktop_qualifiedBuyBox']//input[@id='add-to-cart-button']")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void switchWindow() {
        try {
            String parent = driver.getWindowHandle();
            Set<String> wh = driver.getWindowHandles();

            for (String s : wh) {
                if (!parent.equals(s)) {
                    driver.switchTo().window(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void applyImplicitWait(Duration duration) {
        try {
            driver.manage().timeouts().implicitlyWait(duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
