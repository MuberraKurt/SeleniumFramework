package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import testComponents.BaseTest;

import java.io.IOException;

public class LoginSteps extends BaseTest {
    private LoginPage loginPage;

    public LoginSteps(){
        this.loginPage=getLoginPage();
    }

    @Given("User launches the website")
    public void userLaunchesTheWebsite() throws IOException {
        getDriver().get(getGlobalValue("url"));
    }

    @When("User gives the username and password")
    public void userGivesTheUsernameAndPassword() {

        loginPage.click(loginPage.siginButton);
        loginPage.sendKeysToElement(loginPage.userNameField,"muberrakurt5@gmail.com");
        loginPage.sendKeysToElement(loginPage.passwordField,"Kelebek1.");
        loginPage.click(loginPage.loginButton);
    }


    @Then("Verify logged in succesfully")
    public void verifyLoggedInSuccesfully() {
        loginPage.myFormsButton.isDisplayed();
    }
}
