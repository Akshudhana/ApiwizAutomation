package com.SandboxPomPage;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JsonToXmlNodePage {
	


	@FindBy(xpath = "//p[text()='JSON to XML']/ancestor::div[@class='flex-col gap-2px']")
	private WebElement jsonToXmlNodElement;
	
	@FindBy(xpath = "//div[@class='flex-col br-6px custom__node json_to_xml_transformation-node ghosted border-stroke-section-1px w-max-content']")
    private WebElement addingJsonToXMLElement;
	
	@FindBy(xpath = "//p[text()='Transformer']/ancestor::div[@class='border-stroke-section-1px bg-surface-l2 br-4px custom__node-wrapper  position-relative']")
	private WebElement navigatingJsonNodeElement;
	
	@FindBy(xpath = "//input[@placeholder='Enter Name']")
	private WebElement nameTextFieldElement;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Description']")
	private WebElement descriptionTextFieldElement;
	
	@FindBy(xpath = "//div[text()='Source Variable']/ancestor::div[@class='form__input border-bottom-stroke-subsection-1px flex-row w-100 text-left flex-center br-5px false']/descendant::div[@class='css-1wy0on6']")
    private WebElement sourceVariableDropDownElement;
	
//	@FindBy(xpath = "//div[text()='payload']")
//	private WebElement environmentKeyElement;
	
	@FindBy(xpath = "//input[@placeholder='Enter target variable']")
	private WebElement targetVariableTextFieldElement;
	
	@FindBy(xpath = "//p[text()='Save']")
	private WebElement saveButtonElement;
	

	
	public WebElement getJsonToXmlNodElement() {
		return jsonToXmlNodElement;
	}

	public WebElement getAddingJsonToXMLElement() {
		return addingJsonToXMLElement;
	}

	public WebElement getNavigatingJsonNodeElement() {
		return navigatingJsonNodeElement;
	}

	public WebElement getNameTextFieldElement() {
		return nameTextFieldElement;
	}

	public WebElement getDescriptionTextFieldElement() {
		return descriptionTextFieldElement;
	}

	public WebElement getSourceVariableDropDownElement() {
		return sourceVariableDropDownElement;
	}

	
	public WebElement getTargetVariableTextFieldElement() {
		return targetVariableTextFieldElement;
	}

	public WebElement getSaveButtonElement() {
		return saveButtonElement;
	}
	
	public JsonToXmlNodePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getEnvironmentKeyElement(WebDriver driver,String value) {
	    return driver.findElement(By.xpath("//div[contains(text(),'" + value + "')]"));
	}
	
	
	public void AddJsonToXmlNode(WebDriver driver,String name,String description,String envKey,String targetVariable) throws InterruptedException {
		AddServiceCalloutPage addServiceCalloutPage=new AddServiceCalloutPage(driver);
		addServiceCalloutPage.AddServiceCallout(driver);
		
		Actions actions=new Actions(driver);
		actions.moveToElement(jsonToXmlNodElement).click().perform();
		
		Thread.sleep(3000);
		addingJsonToXMLElement.click();
		
		Thread.sleep(3000);
		navigatingJsonNodeElement.click();
		
		Thread.sleep(3000);
		nameTextFieldElement.sendKeys(name);
		
		Thread.sleep(3000);
		descriptionTextFieldElement.sendKeys(description);
		
		Thread.sleep(3000);
		sourceVariableDropDownElement.click();
		
		Thread.sleep(1000);
		getEnvironmentKeyElement(driver, envKey).click();
		
		Thread.sleep(3000);
		targetVariableTextFieldElement.sendKeys(targetVariable);
		
		Thread.sleep(3000);
		actions.moveToElement(saveButtonElement).click().perform();
		
		
		
	}
}
