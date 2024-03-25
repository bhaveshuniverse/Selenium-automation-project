package stepdefinition;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pageobject.BaseCode;

public class Hooks extends BaseCode {
    @Before
    public static void preScenarioConditions(){

    }
    @After
    public static void postScenarioConditions(){
    driver.quit();
    }
    @BeforeStep
    public static void preStep(){

    }
    @AfterStep
    public static void postStep(Scenario sc){
    byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    sc.attach(screenshot,"image/png",sc.getName());
    }
}
