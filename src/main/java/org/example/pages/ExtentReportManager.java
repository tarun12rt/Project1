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
    private static final String CONFIG_FILE_PATH = "src/test/resources/extent-config.xml"; // Update this path if needed

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

    public static ExtentReports getExtentReports() throws IOException {
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

            // Load the XML configuration
            File configFile = new File(CONFIG_FILE_PATH);
            if (configFile.exists()) {
                htmlReporter.loadXMLConfig(configFile);
            } else {
                System.err.println("ExtentReports configuration file not found at: " + CONFIG_FILE_PATH);
            }

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Tester", "Your Name");
        }
        return extent;
    }

    public static ExtentTest createTest(String testName) throws IOException {
        test = getExtentReports().createTest(testName);
        return test;
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}
