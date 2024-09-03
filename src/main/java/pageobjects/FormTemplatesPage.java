package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.xml.xpath.XPath;

public class FormTemplatesPage extends AbstractComponent{
    public FormTemplatesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Templates
    @FindBy(xpath = "(//a[@data-id='240083148801955'])[3]")
    private WebElement productOrderTemplate;


}
