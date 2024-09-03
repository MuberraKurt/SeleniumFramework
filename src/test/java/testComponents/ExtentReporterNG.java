/*
package testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    static ExtentReports extent;

    public static ExtentReports getReportObject(String scenarioName, String timestamp) {
        String reportFolder = System.getProperty("user.dir") + "/reports/" + scenarioName + "_" + timestamp;

        // Rapor dosyasının yolu
        String path = reportFolder + "/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Result");


        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Müberra");
        return extent;
    }
}*/
