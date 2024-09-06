package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class FormBuilderPage extends AbstractComponent{
    private LoginPage loginPage;

    public FormBuilderPage(WebDriver driver, LoginPage loginPage) {
        super(driver);
        this.loginPage = loginPage;
        PageFactory.initElements(driver, this);
    }

    //Form Elements Menu

    @FindBy(id="field_item_control_head")
    public WebElement heading;

    @FindBy(id="field_item_control_email")
    public WebElement email;

    @FindBy(css = ".jfModal-close")
    public WebElement closeAlert;

    //Form Frame

    @FindBy(id="siteNav_id_settings")
    public WebElement settings;

    @FindBy(id="siteNav_id_publish")
    public WebElement publish;

    @FindBy(id="title")
    public WebElement settingTitle;

   @FindBy(xpath = "(//div[@class='moreMenuLink'])[1]")
    public WebElement MenuOfTheForm;

   @FindBy(xpath = "(//div[@class='quick-preview'])[2]")
    public WebElement MenuviewOfTheForm;

    @FindBy(id="toogleLeftPanel")
    public WebElement addFormElementButton;

    @FindBy(css=".stageEmpty.isSmall")
    public WebElement column1;

    @FindBy(css=".jNewHeader-logo.iBlock")
    public WebElement logo;

    @FindBy(id="field_item_control_payment")
    public WebElement productList;


}
