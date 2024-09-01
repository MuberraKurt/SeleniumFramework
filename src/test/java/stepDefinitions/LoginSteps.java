package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import testComponents.BaseTest;

public class LoginSteps extends BaseTest {

    @Given("User launches the website")
    public void userLaunchesTheWebsite() {

        getLoginPage().Launch_the_Website("https://www.jotform.com");
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
