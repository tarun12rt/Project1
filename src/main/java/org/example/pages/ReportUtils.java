package org.example.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportUtils {
    public static String getReportFileName(String baseName) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        return baseName + "_" + formatter.format(date) + ".html";
    }
}

