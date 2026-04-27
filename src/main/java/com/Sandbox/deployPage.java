package com.Sandbox;

import java.net.http.WebSocket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class deployPage {
	


	@FindBy(xpath = "//div[@data-tooltip-content='Deploy']")
	private WebElement Deploy;
	
	@FindBy(xpath = "//div[@class='text-truncate-1' and text()='Virtual Host']/ancestor::div[@class='form__input border-bottom-stroke-subsection-1px flex-row w-100 text-left flex-center br-5px undefined']/descendant::div[@class='css-1wy0on6']")
    private WebElement VertualHostDropdown;
	
	@FindBy(xpath = "//div[text()='akshatha-dev']")
	private WebElement VertualHostNameSelect;
	
	@FindBy(xpath = "//p[@class='fs-13px fw-600 text-white' and text()='Deploy']")
	private WebElement MainDeployButton;
	
	
	public WebElement getDeploy() {
		return Deploy;
	}

	public WebElement getVertualHostDropdown() {
		return VertualHostDropdown;
	}

	public WebElement getVertualHostNameSelect() {
		return VertualHostNameSelect;
	}

	public WebElement getMainDeployButton() {
		return MainDeployButton;
	}
	
	public deployPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void DeployTheWorkflow(WebDriver driver) throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(Deploy).click().perform();
		
		 Thread.sleep(3000);
		 VertualHostDropdown.click();
		 
		 Thread.sleep(3000);
		 VertualHostNameSelect.click();
		 
		 Thread.sleep(3000);
		 actions.moveToElement(MainDeployButton).click().perform();
		 
		 Thread.sleep(5000);
		 
		 
	}
}
