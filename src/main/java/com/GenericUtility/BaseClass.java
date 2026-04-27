package com.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;


public class BaseClass {
	
	protected static WebDriver driver;

	@BeforeMethod
	public void LaunchBrowse()
	{
		
		 System.out.println("BeforeMethod running");  
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://akshatha-dev.apiwiz.io/");
		
		
	}
	
	
//	//Decleration
//		@FindBy(xpath="//input[@placeholder='Enter Username']")
//		private WebElement userNameTextField;
//		
//		@FindBy(xpath = "//input[@placeholder='Enter Password']")
//		private WebElement passwordTextField;
//		
//		@FindBy(xpath = "//p[@class='text-white dfs-13px fw-500']")
//		private WebElement loginButton;
//		
////		//initilization
////		public BaseClass(WebDriver driver) {
////			PageFactory.initElements(driver, this);
////		}
//
//		//utilization
//		public WebElement getUserNameTextField() {
//			return userNameTextField;
//		}
//
//		public WebElement getPasswordTextField() {
//			return passwordTextField;
//		}
//		
//		
//		//bussiness Logic
//		
//		public void LoginToApp(WebDriver driver,String username,String password) {
//			userNameTextField.sendKeys(username);
//			passwordTextField.sendKeys(password);
//			loginButton.click();
//			
//		}
}
