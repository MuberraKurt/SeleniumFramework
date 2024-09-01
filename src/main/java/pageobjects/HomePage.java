package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractComponent {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".jfHeader-menuListLink.jfHeader-dynamicLink.locale.jfHeader-login-action")
    public WebElement siginButton;

    @FindBy(css = ".currentApp.iBlock")
    public WebElement MyFormsbutton;

}
