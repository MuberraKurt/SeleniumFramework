package stepDefinitions;

import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testComponents.BaseTest;

import java.io.File;
import java.io.IOException;

public class Hooks extends BaseTest {

    @Before
    public void beforeScenario() throws IOException {
        initializeDriver();
        getLoginPage();
        getFormBuilderPage();
    }

    @After
    public void includeScreenshot(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(fileContent,"image/png", "Screenshot");
        }
    }

    @AfterAll
    public static void afterScenario() {
        if (getDriver() != null) {
            closeDriver();
        }
    }
}
