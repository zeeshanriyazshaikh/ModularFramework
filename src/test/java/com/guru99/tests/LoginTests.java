package com.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginTests extends BaseTests{
	@Parameters({"username","userPassword"})
	@Test
	public void verifyUserLoginWithCorrectCredentials(String username,String password) {
		
		reportUtils.createATestCase("verify User Login With Correct Credentials");
		reportUtils.addTestLogs(Status.INFO, "Performing login");
		
		loginpage.loginToApplication(username, password);
		String expectedTitle="Guru99 Bank Manager HomePage";
		String actualTitle=cmndriver.getTitleOfThePage();
		
		reportUtils.addTestLogs(Status.INFO, "comparing actual vs expected title");
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println(actualTitle);
	}
	
	
}
