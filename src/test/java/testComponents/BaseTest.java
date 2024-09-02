package testComponents;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.FormBuilderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pageobjects.LoginPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseTest {
    private static LoginPage loginPage;
    private static FormBuilderPage formBuilderPage;
    private static String browserName;
    private static Properties prop;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriver initializeDriver() throws IOException {
        if (getDriver() == null) {

            browserName = getGlobalValue("browser") != null ? getGlobalValue("browser") : prop.getProperty("browser");

            if (browserName.contains("chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                if (browserName.contains("headless")) {
                    chromeOptions.addArguments("headless");
                }
                driver.set(new ChromeDriver(chromeOptions));
                getDriver().manage().window().setSize(new Dimension(1440, 900));
            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
            } else if (browserName.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
            }
            getDriver().manage().deleteAllCookies();
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            getDriver().manage().window().maximize();
        }

        return getDriver();
    }

    public String getScreenshot(String scenarioName ,String testName) {
        WebDriver driver = getDriver();
        if (driver != null) {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotFolder = System.getProperty("user.dir") + "/reports/" + scenarioName + "_" + date + "/ss";
            String destFile = screenshotFolder + "/" + testName + "_" + date + ".png";
            //String destFile = System.getProperty("user.dir") + "/reports/" + testName + "_" + java.time.LocalDateTime.now() + ".png";
            new File(screenshotFolder).mkdirs();
            try {
                Files.copy(srcFile.toPath(), Paths.get(destFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return destFile;
        } else {
            return "Driver is null, screenshot not taken.";
        }
    }

    public static void closeDriver() {
        WebDriver driver = getDriver();
        if (driver != null) {
            try {
                driver.quit();
                // Ensure the ThreadLocal variable is cleaned up
            } catch (Exception e) {
                System.err.println("Tarayıcıyı kapatma sırasında hata oluştu: " + e.getMessage());
            }
        }
    }

    public String getBrowserName() {
        return browserName;
    }

    public static LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(getDriver());
        }
        return loginPage;
    }

    public static FormBuilderPage getFormBuilderPage() {
        if (formBuilderPage == null) {
            formBuilderPage = new FormBuilderPage(getDriver(), getLoginPage()); // Pass dependencies if needed
        }
        return formBuilderPage;
    }

    public static String getGlobalValue(String key) throws IOException {
        prop = new Properties();
        FileInputStream fis=new FileInputStream("/Users/muberrakurt/Desktop/JotformFramework1/src/test/resources/GlobalData.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }
}