package commonLib.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonDriver {
	//THEORY
	//HERE WILL CREATE AUTOMATION LAYERS,INVOKE BROWSER,NAVIGATE URL,TIMEOUTS.
	
private WebDriver driver;//we have to set it getters so that from outside we can access it as it is private//right click/source/setters and getters

private int pageLoadTimeout;//we have to set it setters so that from outside we can access it as it is private//this are all OOPs concepts to hide

private int elementDetectionTimeout;//we have to set it setters so that from outside we can access it as it is private

//private String currentWorkingDirectory;

	public CommonDriver(String browserType) throws Exception {//common driver here is parameterized constructor
		
		pageLoadTimeout = 20;
		
		elementDetectionTimeout = 20;//10 sec default value if any one fail to set same with pageload also
		
		//currentWorkingDirectory=System.getProperty("user.dir");//it gives current user directory ie: modular framework
		
		if(browserType.equalsIgnoreCase("chrome")) {
			
//			System.setProperty("webdriver.chrome.driver",
//					currentWorkingDirectory + "/drivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("firefox")) {
			
//			System.setProperty("webdriver.chrome.driver",
//					currentWorkingDirectory + "/drivers/gecko.exe");
			WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}
		else {
			throw new Exception("invalid browser type" + browserType);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	public void navigateToUrl(String url) {
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		driver.get(url);
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}
	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}
	
	
	public void closeAllBrowsers() {
		driver.quit();
	}
	public String getTitleOfThePage() {
		return driver.getTitle();
	}
	
	
	
	
	
	
	
	
}
