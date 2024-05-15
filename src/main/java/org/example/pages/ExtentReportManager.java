package org.example.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getExtentReports() {
        if (extent == null) {
            String reportFileName = "target/cucumber-reports/" + ReportUtils.getReportFileName("ExtentReport");
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFileName);
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setDocumentTitle("Automation Test Report");
            htmlReporter.config().setEncoding("utf-8");
            htmlReporter.config().setReportName("Automation Test Results");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Tester", "Your Name");
        }
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        test = getExtentReports().createTest(testName);
        return test;
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}


