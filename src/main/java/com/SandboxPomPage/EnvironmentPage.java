package com.SandboxPomPage;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtils;



public class EnvironmentPage {

	WebDriverUtils webDriverUtil = new WebDriverUtils();
	
	@FindBy(xpath = "//div[@data-tooltip-content='Environments']")
	private WebElement environmentElement;
	
	@FindBy(xpath = "//p[text()='Environments']/parent::div/following-sibling::div//*[name()='svg']")
	private WebElement environmentAddButtonElement;
	
	@FindBy(xpath = "//p[text()='New Environment']/ancestor::div[@class='px-12px py-16px border-stroke-subsection-1px']/descendant::input[@placeholder='Enter Environment Name']")
    private WebElement nametextfieldElement;
	
	@FindBy(xpath = "//p[text()='New Environment']/ancestor::div[@class='px-12px py-16px border-stroke-subsection-1px']/descendant::input[@placeholder='Enter Environment Description']")
    private WebElement descriptionTextFieldElement;
	
	@FindBy(xpath = "//p[text()='New Environment']/ancestor::div[@class='px-12px py-16px border-stroke-subsection-1px']/descendant::input[@placeholder='Key']")
	private WebElement keyTextFieldElement;
	
	@FindBy(xpath = "//p[text()='New Environment']/ancestor::div[@class='px-12px py-16px border-stroke-subsection-1px']/descendant::input[@placeholder='Value']")
	private WebElement valueTextFieldElement;
	


	@FindBy(xpath = "//p[text()='New Environment']/ancestor::div[@class='flex-row vt-center hz-space-between gap-12px']/descendant::div[@class='cursor-pointer h-18px'][2]")
	private WebElement savebuttonElement;
	
	public WebElement getEnvironmentElement() {
		return environmentElement;
	}

	public WebElement getEnvironmentAddButtonElement() {
		return environmentAddButtonElement;
	}

	public WebElement getNametextfieldElement() {
		return nametextfieldElement;
	}

	public WebElement getDescriptionTextFieldElement() {
		return descriptionTextFieldElement;
	}

	public WebElement getKeyTextFieldElement() {
		return keyTextFieldElement;
	}

	public WebElement getValueTextFieldElement() {
		return valueTextFieldElement;
	}
	
	
	public WebElement getSavebuttonElement() {
		return savebuttonElement;
	}

	 public EnvironmentPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void CreateEnvironment(WebDriver driver,String envName,String envDesc,String key,String value) throws InterruptedException {
		 Actions actions=new Actions(driver);
		 
		 Random random=new Random();
		 int ran=random.nextInt(1000);
		    
		 actions.moveToElement(environmentElement).click().perform();
		 Thread.sleep(3000);
		 
		 actions.moveToElement(environmentAddButtonElement).click().perform();
		 Thread.sleep(3000);
		 
		 String envname = envName + "_"+ran;
		 
		 nametextfieldElement.sendKeys(envname);
		 Thread.sleep(3000);
		 
		 descriptionTextFieldElement.sendKeys(envDesc);
		 Thread.sleep(3000);
		 
		 keyTextFieldElement.sendKeys(key);
		 Thread.sleep(3000);
		 
		 valueTextFieldElement.sendKeys(value);
		 Thread.sleep(3000);
		 
		 actions.moveToElement(savebuttonElement).click().perform();
	 }
}
