package com.SandboxPomPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigatingToSandoxPage {
	@FindBy(xpath = "//p[@class='menuItem__path fs-14px fw-500 text-nowrap ' and text()='API Sandbox']/ancestor::div[@class='flex-row vt-center']")
	private WebElement sandboxModuleElement;

	   public WebElement getSandboxModuleElement() 
	   {
			return sandboxModuleElement;
		}
	   
		public NavigatingToSandoxPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public void navigatingToSandbox(WebDriver driver) throws InterruptedException 
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(sandboxModuleElement));
			Thread.sleep(10000);
			sandboxModuleElement.click();
			Thread.sleep(10000); 
			
		}
}
