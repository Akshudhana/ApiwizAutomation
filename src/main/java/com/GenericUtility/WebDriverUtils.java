package com.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebDriverUtils {
	
	public int Randoms() {
	
	  Random random=new Random();
	  int randomnum= random.nextInt(1000);
	  return randomnum;
			
	}
	
	public WebDriverWait waitForDriver(WebDriver driver) {
	    return new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void actionclass(WebDriver driver,WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
			
	
	}
	
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date dt = new Date();
		String date = dateformat.format(dt);
		return date;

	}
	
//	public String takescreenshot(WebDriver driver,String screenshotName) throws IOException 
//	{
//         
//	    
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		String path = ".\\Screeshot\\"+getSystemDateInFormat()+".png";
//		File destination = new File(path);
//		String srcPath = destination.getAbsolutePath();
//		FileUtils.copyFile(src, destination);
//		return srcPath;
//		
//	}
	
	public String takescreenshot(WebDriver driver, String screenshotName) throws IOException {
	    // 1. Safety check: If driver is null, we can't take a screenshot
	    if (driver == null) {
	        System.out.println("Screenshot Error: Driver instance is NULL. Check BaseClass static driver.");
	        return ""; 
	    }

	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);

	    // 2. IMPORTANT: Use System Property to get the project path correctly on Mac
	    String projectPath = System.getProperty("user.dir");
	    String folderPath = projectPath + File.separator + "Screenshot";
	    
	    // 3. Create folder if it doesn't exist
	    File folder = new File(folderPath);
	    if (!folder.exists()) {
	        folder.mkdir();
	    }
	    // 4. Set the final file name
	    String finalFilePath = folderPath + File.separator + screenshotName + "_" + getSystemDateInFormat() + ".png";
	    File destination = new File(finalFilePath);
	    
	    // 5. Save the file
	    FileUtils.copyFile(src, destination);
	    
	    System.out.println("Screenshot successfully saved at: " + finalFilePath);
	    return finalFilePath; 
	}

	
}
