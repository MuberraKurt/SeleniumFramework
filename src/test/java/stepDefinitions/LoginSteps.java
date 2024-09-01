package stepDefinitions;

import io.cucumber.java.BeforeAll;
import testComponents.BaseTest;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class LoginSteps extends BaseTest {

    @Given("I landed on Jotform Page")
    public void ıLandedOnJotformPage() throws IOException {
        homePage = new HomePage(getDriver());
        loginPage = new LoginPage(getDriver());
        getDriver().get("https://jotform.com");
    }

    @Given("Click signin button")
    public void clickSigninButton() {
        homePage.click(homePage.siginButton);
    }

    @And("Log in with userName (.+) and password (.+)$")
    public void logInWithUserNameUserNameAndPasswordPassword(String userName, String password) {
        loginPage.sendKeysToElement(loginPage.userName,userName);
        loginPage.sendKeysToElement(loginPage.passwordElement,password);
    }

    @When("Click login button")
    public void clickLoginButton() {
        loginPage.click(loginPage.loginButton);
    }

    @Then("MyForms button is displayed on HomePage")
    public void myformsButtonIsDisplayedOnHomePage() {
        homePage.waitForElementToAppear(homePage.MyFormsbutton);
        Assert.assertTrue(homePage.MyFormsbutton.isDisplayed());
        getDriver().close();
    }


}
