package stepDefinitions;

import io.cucumber.java.*;
import testComponents.BaseTest;

import java.io.IOException;

public class Hooks extends BaseTest {

    @Before
    public void beforeScenario() throws IOException {
        initializeDriver();
        getLoginPage();
        getFormBuilderPage();
    }

    @AfterAll
    public static void afterScenario() {
        if (getDriver() != null) {
            closeDriver();
        }
    }
}
