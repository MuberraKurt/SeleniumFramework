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
        driver=initializeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        driver.get("https://jotform.com");
    }

    @Given("Click signin button")
    public void clickSigninButton() {
        homePage.waitForElementToAppear(homePage.siginButton);
        homePage.siginButton.click();
    }

    @And("Log in with userName (.+) and password (.+)$")
    public void logInWithUserNameUserNameAndPasswordPassword(String userName, String password) {
        loginPage.waitForElementToAppear(loginPage.userName);
        loginPage.userName.sendKeys(userName);
        loginPage.passwordElement.sendKeys(password);
    }

    @When("Click login button")
    public void clickLoginButton() {
        loginPage.loginButton.click();
    }

    @Then("MyForms button is displayed on HomePage")
    public void myformsButtonIsDisplayedOnHomePage() {
        homePage.waitForElementToAppear(homePage.MyFormsbutton);
        Assert.assertTrue(homePage.MyFormsbutton.isDisplayed());
        driver.close();
    }


}
