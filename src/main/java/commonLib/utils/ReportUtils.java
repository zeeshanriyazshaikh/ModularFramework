package commonLib.utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportUtils {
	ExtentHtmlReporter htmlReport;
	
ExtentReports extentReports;

ExtentTest extentTest;

public ReportUtils(String htmlReportFilename) {//constructor
	
	htmlReportFilename = htmlReportFilename.trim();
	
	htmlReport = new ExtentHtmlReporter(htmlReportFilename);
	
	extentReports = new ExtentReports();
	
	extentReports.attachReporter(htmlReport);
}

public void createATestCase(String testcaseName) {
	extentTest = extentReports.createTest(testcaseName);//this create new test case
	
}
public void addTestLogs(Status status, String comment) {
	extentTest.log(status, comment); //this is method to add logs to reports
	}
public void attachScreenshotToReport(String filename) throws IOException {
	extentTest.addScreenCaptureFromPath(filename); //addScreenCaptureFromPath is pre-defined method
}
public void flushReport() {
	extentReports.flush(); //it will close the report basically
}


}
