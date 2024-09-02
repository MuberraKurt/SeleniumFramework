package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import testComponents.BaseTest;

import java.io.IOException;

public class LoginSteps extends BaseTest {

    @Given("User launches the website")
    public void userLaunchesTheWebsite() throws IOException {

        getLoginPage().Launch_the_Website(getGlobalValue("url"));
    }

    @When("User gives the username and password")
    public void userGivesTheUsernameAndPassword() {

        getLoginPage().Login("muberrakurt5@gmail.com","Kelebek1.");
    }


    @Then("Verify logged in succesfully")
    public void verifyLoggedInSuccesfully() {
        getLoginPage().myFormsButton.isDisplayed();
    }
}
