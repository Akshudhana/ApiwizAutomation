package com.PomPages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RestApiPage {

//	@FindBy(xpath = "//button[@class='vertex-edge-add-button w-14px h-14px flex-center cursor-pointer p-8px']")
//    private WebElement serviceCallOutAddButtoneElement;

	@FindBy(xpath = "//p[text()='REST API' and @class='color-text-regular fs-13px fw-600']/ancestor::div[@class='flex-col gap-2px']")
	private WebElement restApiNodElement;
	
	@FindBy(xpath = "//div[text()='Specification']/ancestor::div[@class='form__input border-bottom-stroke-subsection-1px flex-row w-100 text-left flex-center br-5px undefined']/descendant::div[@class='css-1wy0on6']")
	private WebElement SpecificationDropDown;
	
	@FindBy(xpath = "//div[@class='position-relative overflow-hidden cursor-pointer fs-11px fw-600 text-nowrap px-12px py-8px text-white br-4px bg-surface-blue-dark-hover']")
	private WebElement blankRestApiButtonElement;
	
	@FindBy(xpath = "//div[@class='flex-col br-6px custom__node target-node ghosted border-stroke-section-1px w-max-content']")
	private WebElement addingRestApiNodeToServiceCalloutElement;
	
	@FindBy(xpath = "//p[text()='Service Callout']/ancestor::div[@class='border-stroke-section-1px bg-surface-l2 br-4px custom__node-wrapper  position-relative']")
	private WebElement navigatingInsideTheRestApiServiceCalloutElement;
	
	@FindBy(xpath = "//input[@placeholder='Enter Name']")
	private WebElement nameTextFieldElement;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Description']")
	private WebElement descriptionTextFieldElement;
	
	@FindBy(xpath = "//input[@placeholder='Enter HostName']")
	private WebElement hostTextFieldElement;
	
	@FindBy(xpath = "//input[@placeholder='Enter Path']")
	private WebElement pathTextFieldElement;
	
	@FindBy(xpath = "//p[text()='Save']")
	private WebElement saveButtonElement;
	
	public WebElement getRestApiNodElement() 
	{
		return restApiNodElement;
	}

	public WebElement getSpecificationDropDown() 
	{
		return SpecificationDropDown;
	}

	public WebElement getBlankRestApiButtonElement()
	{
		return blankRestApiButtonElement;
	}

	public WebElement getAddingRestApiNodeToServiceCalloutElement() 
	{
		return addingRestApiNodeToServiceCalloutElement;
	}

	public WebElement getNavigatingInsideTheRestApiServiceCalloutElement()
	{
		return navigatingInsideTheRestApiServiceCalloutElement;
	}

	public WebElement getNameTextFieldElement() 
	{
		return nameTextFieldElement;
	}

	public WebElement getDescriptionTextFieldElement() 
	{
		return descriptionTextFieldElement;
	}

	public WebElement getHostTextFieldElement() 
	{
		return hostTextFieldElement;
	}

	public WebElement getPathTextFieldElement() 
	{
		return pathTextFieldElement;
	}

	public WebElement getSaveButtonElement()
	{
		return saveButtonElement;
	}
	
	public RestApiPage (WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void AddRestApiNodeToServiceCallout(WebDriver driver,String restApiName,String Description,String hostname,String path) throws InterruptedException 
	{
		Actions actions=new Actions(driver);
//		actions.moveToElement(serviceCallOutAddButtoneElement).click().perform();
		
		actions.moveToElement(restApiNodElement).click().perform();
		
		Thread.sleep(5000);
		
		actions.moveToElement(blankRestApiButtonElement).click().perform();
		Thread.sleep(3000);
		
		addingRestApiNodeToServiceCalloutElement.click();
		Thread.sleep(3000);
		
		navigatingInsideTheRestApiServiceCalloutElement.click();
		Thread.sleep(3000);
		
		nameTextFieldElement.sendKeys(restApiName);
		Thread.sleep(3000);
		
		descriptionTextFieldElement.sendKeys(Description);
		Thread.sleep(3000);
		
		hostTextFieldElement.sendKeys(hostname);
		Thread.sleep(3000);
		
		pathTextFieldElement.sendKeys(path);
		Thread.sleep(3000);
		
		actions.moveToElement(saveButtonElement).click().perform();
		Thread.sleep(3000);		
		
	}
	
}
