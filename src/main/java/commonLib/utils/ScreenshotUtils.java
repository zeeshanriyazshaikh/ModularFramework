package commonLib.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	private TakesScreenshot camera; //TakesScreenshot is a interface by selenium ,and camera is instance of TakesScreenshot
	
public ScreenshotUtils(WebDriver driver) {
	
	camera = (TakesScreenshot) driver; //so that same browser can take screen shots//initialising camera,driver instance will typecasting(typeconversion) interface TakesScreenshot,driver is instance of webdriver interface,
}

public void captureAndSaveScreenshot(String filename) throws Exception {
	filename = filename.trim();
	
	File imgFile, tmpFile;
	
	imgFile = new File(filename);
	
	if(imgFile.exists()) {
		throw new Exception("File already exists");
	}
	tmpFile = camera.getScreenshotAs(OutputType.FILE); //camera is variable on behalf of to take screen shot,
	
	FileUtils.moveFile(tmpFile, imgFile);  //src file, destination file
}
}
