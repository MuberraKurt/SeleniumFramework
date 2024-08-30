package testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;


public class Listeners extends BaseTest implements ITestListener {
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.info("Browser: "+ browserName);
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
        test.fail(result.getThrowable());

        String screenshotPath = getScreenshot(result.getMethod().getMethodName());
        try {
            test.addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (driver != null) {
            closeDriver();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}