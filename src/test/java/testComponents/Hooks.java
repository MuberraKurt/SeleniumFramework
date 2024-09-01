package testComponents;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks extends BaseTest{

    @Before
    public void beforeScenario() throws IOException {
        initializeDriver();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (getDriver() != null) {
            closeDriver(); // Ensure proper cleanup of WebDriver
        }
    }
}
