package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//THEORY
//BENEFITS OF PAGE FACTORY IS,ALL THOSE ELEMENTS DYNAMIC IN NATURE,THAT LOADS LATE ON PAGE WHEN SCROLLING DOWN ALSO,OR FOR SOME OTHER OPERATION HAPPENS,ALL THESE ELEMENT IF WE INITIALIZE NORMAL WAY LIKE DRIVER,FIBDBYELEMENT,THEY WILL THROW EXCEPTION AS ELEMENT NOT FOUND EXCEPTION,IF NOT AVAILABLE.
//BUT IF WE ARE USING @FindBy ANNOTATION,THEY WILL NOT THROW EXCEPTION RATHER DRIVER INSTANCE WILL NOT ONLY AT THE TIME OF INITIALIZATION BUT DRIVER INSTANCE WILL SEARCH ELEMENTS AT TIME OF INTERACTION AS WELL.
//ANOTHER BENEFIT IS ANY ELEMENT IS STATIC ELEMENT WE CAN ADD THEM INTO @CacheLookup,
public class LoginPage extends BasePage {
@CacheLookup
	@FindBy(name="uid")
	private WebElement userId;
@CacheLookup
	@FindBy(name="password")
	private WebElement userPassword;
@CacheLookup
	@FindBy(name="btnLogin")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {//constructor of login page,and driver instance required
		super(driver);
		PageFactory.initElements(driver, this);//to initialize above elements we have page factory class, and initElements method,initialize all elements in driver instance,and this means all element in this class
		
	}
	//NOW WE WILL  ADD LOGICS HERE
	public void loginToApplication(String username, String passord) {
		elementcontrol.setText(userId, username);
		elementcontrol.setText(userPassword, passord);
		elementcontrol.clickElement(loginButton);
	}
}
