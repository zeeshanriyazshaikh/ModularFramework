package commonLib.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementControl {
//THEORY
//HERE WILL WRITE CUSTOM METHODS ALSO CALLED WRAPPER METHODS TO PERFORM SENDKEYS,HANDLING ALERTS.
//WRAPPER METHODS MEANS WRITING CUSTOM METHODS TO WRAP THE FUNCTIONALITY PROVIDED BY EXTERNAL LIBRARIES,IT HELP IN CASE THE IMPLEMENTATION OF EXTERNAL FILE CHANGE OR DEPRECATED
	WebDriver driver;
public ElementControl(WebDriver driver) {
	this.driver=driver;                 //again we are using concept of where we are passing variable which we are getting from argument of a method to a class level variable,now driver variable will be available within this class,that we will get from common driver
}	
	
	public void clickElement(WebElement element) {//CLICK
		element.click();
	}
	
	public void setText(WebElement element,String text) {//SENDKEYS
		element.sendKeys(text);;
	}
	public boolean isEnabled(WebElement element) {//IS ENABLED
		return element.isEnabled();
	}
	public boolean isDisplayed(WebElement element) {//IS DISPLAYED
		return element.isDisplayed();
	}
	public boolean isSelected(WebElement element) {//IS SELECTED
		return element.isSelected();
	}
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	public String getTextFromAlert() {
		return driver.switchTo().alert().getText();
	}
	public void selectViaVisibleText(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
}
