package com.PomPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	
		//Decleration
				@FindBy(xpath="//input[@placeholder='Enter Username']")
				private WebElement userNameTextField;
				
				@FindBy(xpath = "//input[@placeholder='Enter Password']")
				private WebElement passwordTextField;
				
				@FindBy(xpath = "//p[@class='text-white dfs-13px fw-500']")
				private WebElement loginButton;
				
				//initilization
				public LoginPage(WebDriver driver) {
					this.driver = driver;
					PageFactory.initElements(driver, this);
				}

				//utilization
				public WebElement getUserNameTextField() {
					return userNameTextField;
				}

				public WebElement getPasswordTextField() {
					return passwordTextField;
				}
				
				
				//bussiness Logic
				
				public void AkshathadevStageLogin()
				{
					driver.get("https://akshatha-dev.apiwiz.io/");
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			        wait.until(ExpectedConditions.visibilityOf(userNameTextField));
					userNameTextField.sendKeys("TeamUserAnkit");
					wait.until(ExpectedConditions.visibilityOf(passwordTextField));
					passwordTextField.sendKeys("Devuseraccount@10");
					wait.until(ExpectedConditions.visibilityOf(loginButton));
					loginButton.click();
					
				}
				
				
				public void AcmeteamProductionLogin()
				{
					driver.get("https://acme-team-production.apiwiz.io/auth");
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			        wait.until(ExpectedConditions.visibilityOf(userNameTextField));
					userNameTextField.sendKeys("AkshathaSM");
					wait.until(ExpectedConditions.visibilityOf(passwordTextField));
					passwordTextField.sendKeys("L8#kR!9vPz@4tQ2sAD510");
					wait.until(ExpectedConditions.visibilityOf(loginButton));
					loginButton.click();
				}
	}

