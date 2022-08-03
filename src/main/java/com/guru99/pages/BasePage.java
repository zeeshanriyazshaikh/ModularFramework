package com.guru99.pages;

import org.openqa.selenium.WebDriver;

import commonLib.implementation.ElementControl;

public class BasePage {
	WebDriver driver;
	
	public ElementControl elementcontrol;
	
	public BasePage(WebDriver driver) {
		
		this.driver=driver;
		
		elementcontrol =new ElementControl(driver);
	}
}
