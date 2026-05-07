package com.SandboxPomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddServiceCalloutPage {
	@FindBy(xpath = "//button[@class='vertex-edge-add-button w-14px h-14px flex-center cursor-pointer p-8px']")
	   private WebElement serviceCallOutAddButtoneElement;
	
	   public WebElement getServiceCallOutAddButtoneElement() {
			return serviceCallOutAddButtoneElement;
		}
	   
		public AddServiceCalloutPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		public void AddServiceCallout(WebDriver driver) 
		{
			Actions actions=new Actions(driver);
			actions.moveToElement(serviceCallOutAddButtoneElement).click().perform();
		}

}
