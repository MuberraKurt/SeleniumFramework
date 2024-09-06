package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pageobjects.FormBuilderPage;
import pageobjects.LoginPage;
import testComponents.BaseTest;

public class FormBuilderSteps extends BaseTest {
    private LoginPage loginPage;
    private FormBuilderPage formBuilderPage;
    public FormBuilderSteps() {
        this.loginPage = getLoginPage();
        this.formBuilderPage = getFormBuilderPage();

    }
    @Given("User lands on the Form Builder page")
    public void userLandsOnTheFormBuilderPage() {
        formBuilderPage.hoverAndClick(loginPage.products,loginPage.formBuilder);
    }

    @When("User selects the items and add them to the form")
    public void userSelectsTheItemsAndAddThemToTheForm() throws InterruptedException {
        formBuilderPage.handleAlert();
        formBuilderPage.click(formBuilderPage.closeAlert);
        formBuilderPage.click(formBuilderPage.addFormElementButton);
        formBuilderPage.dragAndDrop(formBuilderPage.productList,formBuilderPage.column1);
        formBuilderPage.click(formBuilderPage.heading);
        formBuilderPage.click(formBuilderPage.email);
        formBuilderPage.click(formBuilderPage.settings);
        formBuilderPage.cleanValue(formBuilderPage.settingTitle);
        formBuilderPage.sendKeysToElement(formBuilderPage.settingTitle, "a");

    }


    @Then("Verify the form is created")
    public void verifyTheFormIsCreated() {
        formBuilderPage.click(formBuilderPage.publish);
        formBuilderPage.click(formBuilderPage.logo);
        Assert.assertEquals(loginPage.titleofTheForm.getText(),"a");
    }
}
