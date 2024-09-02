package testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporterNG {
    static ExtentReports extent;

    public static ExtentReports getReportObject(String scenarioName) {
        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportFolder = System.getProperty("user.dir") + "/reports/" + scenarioName + "_" + date;

        // Rapor dosyasının yolu
        String path = reportFolder + "/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Müberra");
        return extent;
    }
}
