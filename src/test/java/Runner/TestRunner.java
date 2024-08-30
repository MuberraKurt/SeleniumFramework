package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//cucumber -> TestNG, Junit
@CucumberOptions(
        features = "src/test/java/featureFiles",
        glue = "stepDefinitions"
        ,monochrome = true ,
        plugin ={"html:target/cucumber.html"
                })
public class TestRunner extends AbstractTestNGCucumberTests {

}
