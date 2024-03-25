package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobject.AmazonCartPage;
import pageobject.AmazonHomepage;
import pageobject.BaseCode;

import java.io.IOException;

public class ShippingSteps extends BaseCode {
    @Given("user opens the mycart")
    public static void openMycart() throws IOException {
        AmazonHomepage.openCart();
    }

    @When("user increases the quantity")
    public void increaseQuantity() {
        AmazonCartPage.increaseToQuantity("2");
    }

    @And("user moves into checkout page")
    public void checkoutPage() {
        AmazonCartPage.proceedToCheckout();
    }

    @Then("user validates for the checkout page")
    public void validateCheckoutPage() {
        Assert.assertEquals("True",AmazonCartPage.validatePage());
    }
}
