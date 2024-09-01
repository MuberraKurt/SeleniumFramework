package testComponents;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public HomePage homePage ;
    public LoginPage loginPage ;
    private static String browserName;
    private static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public static WebDriver initializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/muberrakurt/Documents/JotformFramework/src/main/resources/GlobalData.properties");
        prop.load(fis);

        browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");

        if(browserName.contains("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if(browserName.contains("headless")) {
                chromeOptions.addArguments("headless");
            }

            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().setSize(new Dimension(1440,900));

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("geckodriver","/Users/muberrakurt/Downloads/geckodriver");
            driver= new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver","edge.exe");
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;
    }


    public String getScreenshot(String testName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destFile = System.getProperty("user.dir") + "/reports/" + testName +" | " + java.time.LocalDateTime.now() + ".png";
        try {
            Files.copy(srcFile.toPath(), Paths.get(destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destFile;
    }


    public void closeDriver(){
        if (driver != null) {
            try {
                driver.quit(); // Tarayıcıyı kapat
            } catch (Exception e) {
                System.err.println("Tarayıcıyı kapatma sırasında hata oluştu: " + e.getMessage()); // Hata mesajını logla
            } finally {
                driver = null; // Tarayıcıyı null yap
            }
        }
    }



    // Tarayıcı adını elde etmek için metod
    public String getBrowserName() {
        return browserName;
    }
}
