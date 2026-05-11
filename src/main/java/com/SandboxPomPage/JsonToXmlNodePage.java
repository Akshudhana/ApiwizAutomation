package com.SandboxPomPage;



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
	
	@FindBy(xpath = "//div[text()='JSON was successfully converted to XML' and @class='fs-12px fw-500 color-text-regular text-truncate-1 flex-row vt-center gap-6px']")
	private WebElement JSONWasSuccessfullyConvertedToXML;
	
    @FindBy(xpath = "//div[@class='cslr selected-text top-left-radius bottom-left-radius top-right-radius bottom-right-radius']")
    private WebElement xmlBodyElement;

	@FindBy(xpath = "//div[text()='JSON was successfully converted to XML']/ancestor::div[@class='h-33px px-8px flex-row hz-space-between vt-center hover-bg-surface-ground-hover border-bottom-stroke-subsection-1px cursor-pointer']/descendant::div[@data-tooltip-place='top'][1]")
    private WebElement jSONWasSuccessfullyConvertedToXMLDEtailsViewElement;
    
	
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
	
    
    public WebElement getjSONWasSuccessfullyConvertedToXMLDEtailsViewElement() {
		return jSONWasSuccessfullyConvertedToXMLDEtailsViewElement;
	}
    
	public JsonToXmlNodePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getEnvironmentKeyElement(WebDriver driver,String value) {
	    return driver.findElement(By.xpath("//div[contains(text(),'" + value + "')]"));
	}
	
	
	public void AddJsonToXmlNode(WebDriver driver,String name,String description,String envKey,String targetVariable) throws InterruptedException {
//		AddServiceCalloutPage addServiceCalloutPage=new AddServiceCalloutPage(driver);
//		addServiceCalloutPage.AddServiceCallout(driver);
		
		Actions actions=new Actions(driver);
		actions.moveToElement(jsonToXmlNodElement).click().perform();
		System.out.println("jsontoxml node identified");
		
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
	
//	public void validatingTheXMLDataAfterConvertingFronJsonToXML(WebDriver driver) throws InterruptedException {
//		
////		String actualTitle="JSON was successfully converted to XML";
//
//        
//		String jsonWasSuccessfullyConvertedToXMLText = JSONWasSuccessfullyConvertedToXML.getText();
//		System.out.println("jsonWasSuccessfullyConvertedToXMLText----->"+jsonWasSuccessfullyConvertedToXMLText);
//		
//	if (jsonWasSuccessfullyConvertedToXMLText.contains("JSON was successfully converted to XML")) {
//	    System.out.println("successful1");
//	} else {
//	    System.out.println("failed1");
//	}
////	Assert.assertEquals(JSONWasSuccessfullyConvertedToXMLs, "JSON was successfully converted to XML");
//
//	Thread.sleep(3000);
//	Actions actions = new Actions(driver);
//	actions.moveToElement(jSONWasSuccessfullyConvertedToXMLDEtailsViewElement).click().perform();
//		String xmlData = xmlBodyElement.getText();
//		
//		if (xmlData.equals("<User>admin</User>")) {
//			System.out.println("successfull");
//		}
//		else {
//			System.out.print("fail");
//		}
//		
//	}
}
