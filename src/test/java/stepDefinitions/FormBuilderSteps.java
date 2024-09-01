package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.FormBuilderPage;
import testComponents.BaseTest;

public class FormBuilderSteps extends BaseTest {

    @Given("User lands on the Form Builder page")
    public void userLandsOnTheFormBuilderPage() {
        getFormBuilderPage().landsOnTheFormBuilderPage();
    }

    @When("User selects the items and add them to the form")
    public void userSelectsTheItemsAndAddThemToTheForm() {
        getFormBuilderPage().selectsTheItemsAndAddThemToTheForm();
    }


    @Then("Verify the form is created")
    public void verifyTheFormIsCreated() {

        getFormBuilderPage().verifyTheFormisCreated();
    }
}
