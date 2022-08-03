package com.guru99.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.guru99.pages.LoginPage;

import commonLib.implementation.CommonDriver;
import commonLib.utils.ConfigUtils;
import commonLib.utils.ReportUtils;
import commonLib.utils.ScreenshotUtils;

public class BaseTests {
	
	CommonDriver cmndriver;
	String url;
	WebDriver driver;
	LoginPage loginpage;
	String configFileName;
	String currentWorkingDirectory;
	Properties configProperty;
	
	String reportFileName;
	ReportUtils reportUtils;
	
	ScreenshotUtils screenshot;
	@BeforeSuite
	public void preSetup() throws IOException {
		currentWorkingDirectory = System.getProperty("user.dir");
		
		configFileName = currentWorkingDirectory + "/config/config.properties";
		configProperty  = ConfigUtils.readProperties(configFileName);
		
		reportFileName = currentWorkingDirectory + "/reports/guru99TestReport.html";
		reportUtils = new ReportUtils(reportFileName);
		
	}
	
@BeforeClass
public void setUp() throws Exception{
	
	url = configProperty.getProperty("baseUrl"); //url = "http://demo.guru99.com/v4";
	String browserType = configProperty.getProperty("browserType");
	
	cmndriver=new CommonDriver(browserType);
	
	driver=cmndriver.getDriver();//initializing driver here as we can access here and login test class as well
	
	loginpage = new LoginPage(driver);
	
	screenshot = new ScreenshotUtils(driver); //screenshot initialization of ScreenshotUtils class
	
	cmndriver.navigateToUrl(url);
}
@AfterMethod
public void postTestAtion(ITestResult result) throws Exception { //this logic will execute after each test case run,ITestResult store result of each test case
	
	String testcasename = result.getName();
	
	long executionTime = System.currentTimeMillis();
	
	String screenshotFilename = currentWorkingDirectory + 
			"/screenshots/"
			+ testcasename + executionTime +".jpeg";//we are creating jpeg file in screenshot folder with testcasename and execution time,to distinguish file name
	if(result.getStatus() == ITestResult.FAILURE){
		
	reportUtils.addTestLogs(Status.FAIL, "one or more steps failed");
	screenshot.captureAndSaveScreenshot(screenshotFilename);
	reportUtils.attachScreenshotToReport(screenshotFilename);
	}
}
@AfterClass
public void tearDown() {
	
	cmndriver.closeAllBrowsers();
}
@AfterSuite
public void postTearDown() {
	reportUtils.flushReport();
}

}
