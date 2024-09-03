/*
package testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Listeners extends BaseTest implements ITestListener {
    private ExtentReports extent;
    private ExtentTest test;
    private String timestamp;

    public Listeners() {
        // Generate the timestamp once for the entire test run
        this.timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        this.extent = ExtentReporterNG.getReportObject("TestRunner", timestamp);
    }

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
        String scenarioName = result.getMethod().getXmlTest().getName();
        String testName = result.getMethod().getMethodName();
        test = extent.createTest(testName);
        test.fail(result.getThrowable().getMessage());

        if (getDriver() != null) {
            String screenshotPath = getScreenshot(scenarioName, testName, timestamp);
            try {
                test.addScreenCaptureFromPath(screenshotPath, testName);
            } catch (IOException e) {
                test.fail("Failed to attach screenshot: " + e.getMessage());
            }
        } else {
            test.fail("Driver is null, cannot take screenshot.");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}*/
