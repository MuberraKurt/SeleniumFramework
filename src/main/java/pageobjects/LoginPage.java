package pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponent {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "username") //PageFactory
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement passwordElement;

    @FindBy(id ="signinButton")
    public WebElement loginButton;

    public void loginApplication(String username, String password){
        userName.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButton.click();
    }

}
