package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobject.AmazonHomepage;
import pageobject.AmazonLoginPage;
import pageobject.BaseCode;

import java.io.IOException;

public class LoginSteps extends BaseCode {
    @Given("user opens an amazon website")
    public static void openAmazonWebsite() throws IOException {
        browserInvocation();
    }

    @When("user fills the username and password")
    public void fillLoginDetails() {
        AmazonHomepage.navigatToLoginPage();
        AmazonLoginPage.fillLoginCredentials();
    }

    @And("user logins into the amazon website")
    public void loginAmazon() {
        AmazonLoginPage.amazonLogin();
    }

    @Then("user validates that login is successful")
    public void validateLogin() {
        Assert.assertEquals("True",AmazonLoginPage.isUserLoggedIn());
    }
}
