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
       //click(loginPage.testd);
       hoverAndClick(loginPage.products,loginPage.formBuilder);
       System.out.println("loginPage.formBuilder");

   }

   public void selectsTheItemsAndAddThemToTheForm(){
       try {
           // Attempt to switch to an alert
           Alert alert = driver.switchTo().alert();
           alert.accept(); // Accept the alert
           System.out.println("JavaScript alert closed successfully.");
       } catch (NoAlertPresentException e) {
           // If no alert is present, print a message and proceed
           System.out.println("No alert was present.");
       }try {
           WebElement closeButton = driver.findElement(By.cssSelector(".jfModal-close"));

           // Wait until the close button is clickable
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           wait.until(ExpectedConditions.elementToBeClickable(closeButton));

           // Use JavaScript to click the element to avoid any overlay issues
           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("arguments[0].click();", closeButton);

           System.out.println("Close alert button clicked successfully.");
       } catch (NoSuchElementException e) {
           System.out.println("Close alert button not found.");
       } catch (InvalidElementStateException e) {
           System.out.println("Element is not in a valid state to interact with: " + e.getMessage());
       }
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
