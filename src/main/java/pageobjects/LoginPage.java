package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponent {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //LoginPage
    @FindBy(id = "username") //PageFactory
    public WebElement userNameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id ="signinButton")
    public WebElement loginButton;

    //Before Login or SignUp
    @FindBy(css=".jfHeader-logoLink:first-of-type")
    public WebElement heading;

    @FindBy(css=".jfHeader-menuListLink.jfHeader-dynamicLink.locale.jfHeader-login-action")
    public WebElement siginButton;

    @FindBy(css="#loginSignup>li:nth-child(2)")
    public WebElement signUpButton;

    @FindBy(css="ul.jfHeader-menuList.jfHeader-menubsg>li:nth-child(2)")
    public WebElement myFormsPL;

    @FindBy(css="ul.jfHeader-menuList.jfHeader-menubsg>li:nth-child(3)")
    public WebElement templatesPL;

    @FindBy(css="ul.jfHeader-menuList.jfHeader-menubsg>li:nth-child(4)")
    public WebElement integrationsPL;

    @FindBy(css="ul.jfHeader-menuList.jfHeader-menubsg>li:nth-child(5)")
    public WebElement productsPL;

    @FindBy(css="ul.jfHeader-menuList.jfHeader-menubsg>li:nth-child(6)")
    public WebElement supportPL;

    @FindBy(css="ul.jfHeader-menuList.jfHeader-menubsg>li:nth-child(7)")
    public WebElement enterprisePL;

    @FindBy(css="ul.jfHeader-menuList.jfHeader-menubsg>li:nth-child(8)")
    public WebElement pricingPL;

    //PostLogin
    @FindBy(css = ".currentApp.iBlock")
    public WebElement myFormsButton;

    @FindBy(css=".jfHeader-menuListItem.hasSubMenu.hasIcon.subMenuTitleProducts")
    public WebElement products;

    @FindBy(xpath = "(//ul[@class='jfHeader-menuList jfHeader-menubsg']//li)[1]")
    public WebElement templates;

        //Template Submenu
    @FindBy(xpath = "(//li[@class='jfHeader-subMenuItem']//a)[1]")
    public WebElement formTemplates;

        //Products Submenu
    @FindBy(xpath = "//a[@data-text-name='formBuilder']")
    public WebElement formBuilder;

    @FindBy(xpath = "(//div[@class='lsApp-list-item-title'])[1]")
    public WebElement titleofTheForm;

        //---

    public void Launch_the_Website(String url){
        driver.get(url);
    }

    public void Login(String username, String password){
        click(siginButton);
        sendKeysToElement(userNameField,username);
        sendKeysToElement(passwordField,password);
        click(loginButton);
    }

}
