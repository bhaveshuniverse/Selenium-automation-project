package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.BaseCode;

import java.io.IOException;

import static pageobject.FlipkartHomePage.saveMobilePhonesList;
import static pageobject.FlipkartHomePage.searchProduct;

public class SearchMobilePhonesSteps extends BaseCode {

    @Given("user opens the flipkart website")
    public static void openFlipkartWebsite() throws IOException {
        browserInvocation();
    }

    @When("user searches the product")
    public void userSearchesTheProduct() {
        searchProduct();
    }

    @Then("user stores the list of products into an excel file")
    public void userStoresTheListOfProductsIntoAnExcelFile() throws IOException {
        saveMobilePhonesList();
    }
}
