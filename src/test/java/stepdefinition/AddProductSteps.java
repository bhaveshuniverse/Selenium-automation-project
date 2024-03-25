package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.AmazonHomepage;
import pageobject.AmazonProductPage;
import pageobject.BaseCode;

import java.io.IOException;
import java.time.Duration;

public class AddProductSteps extends BaseCode {

    @Given("user search for the product in amazon website")
    public static void searchProduct() throws IOException {
        browserInvocation();
        AmazonHomepage.searchKeyword();
    }

    @When("user selects a particular product")
    public void chooseProduct() {
        AmazonProductPage.selectProduct();
    }

    @And("user chooses a particular specification")
    public void chooseSpecification() {
        switchWindow();
        AmazonProductPage.select256GB();
    }

    @Then("user adds that product to amazon cart")
    public void userAddsThatProductToAmazonCart() {
        waitForSomeTime(Duration.ofSeconds(100),"//div[@id='desktop_qualifiedBuyBox']//input[@id='add-to-cart-button']");
        AmazonProductPage.addToCart();
    }


}
