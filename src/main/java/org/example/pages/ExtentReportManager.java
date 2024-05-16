package org.example.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;
    private static final String REPORTS_DIR = "Reports/cucumber-reports";
    private static final String LATEST_REPORTS_DIR = REPORTS_DIR + "/LatestReports";

    public static void setupLatestReportDir() throws IOException {
        File latestReportsDir = new File(LATEST_REPORTS_DIR);
        if (latestReportsDir.exists()) {
            // Delete existing contents
            for (File file : latestReportsDir.listFiles()) {
                if (!file.isDirectory()) {
                    file.delete();
                }
            }
        } else {
            // Create the directory
            latestReportsDir.mkdirs();
        }
    }

    public static String getLatestReportFileName(String baseName) {
        return LATEST_REPORTS_DIR + "/" + ReportUtils.getReportFileName(baseName);
    }

    public static ExtentReports getExtentReports() {
        if (extent == null) {
            try {
                setupLatestReportDir();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String reportFileName = getLatestReportFileName("ExtentReport");
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
