package testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;


public class Listeners extends BaseTest implements ITestListener {
    ITestResult testResult;
    ExtentReports extent = ExtentReporterNG.getReportObject("TestResult");
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.info("Browser: "+ getBrowserName());
        test.info("Operating System: " + System.getProperty("os.name"));
        test.info("Test Start Time: " + java.time.LocalDateTime.now());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
        test.info("Test Duration: "+(result.getEndMillis()-result.getStartMillis())+" ms");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String scenarioName = result.getMethod().getXmlTest().getName();  // Senaryo adını al
        String testName = result.getMethod().getMethodName();
        test.fail(result.getThrowable().getMessage());
        if (getDriver() != null) {
            String screenshotPath = getScreenshot(scenarioName, testName);
            try {
                test.addScreenCaptureFromPath(screenshotPath, testName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            test.fail("Driver is null, cannot take screenshot.");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}