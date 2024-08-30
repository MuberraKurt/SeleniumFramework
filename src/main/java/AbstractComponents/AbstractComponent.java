package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToAppear(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToDisappear(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void scrollByVisibilityofElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }

    public void sendKeysToElement(WebElement element, String keysToSend){
        waitForElementToAppear(element);
        scrollByVisibilityofElement(element);
        element.clear();
        element.sendKeys(keysToSend);
    }

    public void click(WebElement element){
        waitForElementClickable(element);
        scrollByVisibilityofElement(element);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void selectByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectByIndex(WebElement element, int index){
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void selectByVisibleText(WebElement element, String visibleText){
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public void rightClick(WebElement element){
        Actions clicker=new Actions(driver);
        clicker.contextClick(element).perform();
    }

    public String getCurrentUrl(){
        String url = driver.getCurrentUrl();
        return url;
    }
}
