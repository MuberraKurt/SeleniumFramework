package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

    @FindBy(css="#header_1>div")
    public WebElement headerOfTheForm;

   @FindBy(xpath = "(//div[@class='lsApp-list-item-title'])[1]")
    public WebElement titleofTheForm;

   @FindBy(xpath = "(//div[@class='moreMenuLink'])[1]")
    public WebElement MenuOfTheForm;

   @FindBy(xpath = "(//div[@class='quick-preview'])[2]")
    public WebElement MenuviewOfTheForm;

    @FindBy(css=".toggleIcon-wrapper")
    public WebElement addFormElementButton;

   public void landsOnTheFormBuilderPage() {
       click(loginPage.testd);
       /*click(loginPage.products);
       click(loginPage.formBuilder);
       click(closeAlert);*/
   }

   public void selectsTheItemsAndAddThemToTheForm(){
       click(addFormElementButton);
       click(heading);
       click(email);
       headerOfTheForm.clear();
       sendKeysToElement(headerOfTheForm,"abc");
   }


   public void verifyTheFormisCreated(){
       click(loginPage.heading);
       Assert.assertEquals(titleofTheForm.getText(),"abc");
   }


}
