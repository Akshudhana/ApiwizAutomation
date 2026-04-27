package com.Sandbox;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtility.WebDriverUtils;

public class AddCollection {
	
	
	WebDriverUtils webDriverUtil = new WebDriverUtils();
	String expectedCollectionSaveMsg = "Collection created successfully";

	
	@FindBy(xpath = "//p[@class='menuItem__path fs-14px fw-500 text-nowrap ' and text()='API Sandbox']/ancestor::div[@class='flex-row vt-center']")
	private WebElement sandboxModuleElement;
	

	@FindBy(xpath = "//div[@data-tooltip-content='Add Collection']")
	private WebElement addCollectionElement;
	
	@FindBy(xpath = "//input[@placeholder='Enter Name' or @class='undefined  isDefault undefined null null w-100 formInputTag']")
	private WebElement collectionNameTextFieldElement;
	
	@FindBy(xpath = "//p[text()='Overview' and @class='color-text-regular fs-16px fw-600']/ancestor::div[@class='flex-row vt-center hz-space-between px-8px py-6px h-36px border-bottom-stroke-section-1px']//descendant::*[name()='svg' and @class='color-text-regular'][2]")
	private WebElement collectionSaveButtonElement;

	@FindBy(xpath = "//div[@class='Toastify__toast-body']")
	private WebElement collectionSavetoastMsgElement;
	
	@FindBy(xpath = "//p[@class='text-truncate-1 fs-13px fw-500 color-text-regular' and text()='Start with Blank Template']/ancestor::div[@class='bg-surface-l1 flex-row vt-center hz-space-between gap-6px zIndex-2 pr-8px']/descendant::div[@class='flex-row vt-center form__radio cursor-pointer min-w-0']")
	private WebElement StartWithBlank;
	
	@FindBy(xpath = "//p[@class='text-truncate-1 fs-13px fw-500 color-text-regular' and text()='Start with Blank Template']/ancestor::div[@class='bg-surface-l1 flex-row vt-center hz-space-between gap-6px zIndex-2 pr-8px']/descendant::div[@class='flex-row vt-center form__radio cursor-pointer min-w-0']")
    private WebElement startWithBlankRadioButtonElement;
    
    @FindBy(xpath = "//p[@class='fw-500 fs-13px text-white' and text()='Next']/ancestor::div[@class='position-relative overflow-hidden btn-primary cursor-pointer']")
    private WebElement startWithBlankNextButtonElement;
    
    @FindBy(xpath = "//input[@placeholder='Enter Name']")
    private WebElement workFlowNameTextFieldElement;
    
    @FindBy(xpath = "//input[@placeholder='Enter URL']")
    private WebElement workFlowURLTextFieldElement;
    
    @FindBy(xpath = "//p[@class='color-text-regular fs-13px fs-13px fw-500' and text()='Save']")
    private WebElement workflowSaveButtonElement;
	
	public WebElement getSandboxModuleElement() {
		return sandboxModuleElement;
	}

	public WebElement getAddCollectioneElement() {
		return addCollectionElement;
	}

	public WebElement getAddCollectionNameElement() {
		return collectionNameTextFieldElement;
	}

	public WebElement getCollectionSaveButtonElement() {
		return collectionSaveButtonElement;
	}

	public WebElement getCollectionSavetoastMsgElement() {
		return collectionSavetoastMsgElement;
	}
	
    public WebElement getStartWithBlankRadioButtonElement() {
		return startWithBlankRadioButtonElement;
	}

	public WebElement getStartWithBlankNextButtonElement() {
		return startWithBlankNextButtonElement;
	}

	public WebElement getWorkFlowNameTextFieldElement() {
		return workFlowNameTextFieldElement;
	}

	public WebElement getWorkFlowURLTextFieldElement() {
		return workFlowURLTextFieldElement;
	}

	public WebElement getWorkflowSaveButtonElement() {
		return workflowSaveButtonElement;
	}

	
	// generate collection name when needed
    public String generateCollectionName(String collectionname) {
        return collectionname + webDriverUtil.Randoms();
    }
    
	public AddCollection(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	public void createCollection(WebDriver driver,String collectionName) throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(sandboxModuleElement));
		Thread.sleep(10000);
		sandboxModuleElement.click();
	
		Thread.sleep(10000);        
		addCollectionElement.click();
	
		Thread.sleep(5000);
		collectionNameTextFieldElement.sendKeys(collectionName);

		Thread.sleep(5000);
		
		Actions actions = new Actions(driver);
        actions.moveToElement(collectionSaveButtonElement).click().perform();
        
     WebElement collectionName_toast_message=  wait.until(ExpectedConditions.visibilityOf(collectionSavetoastMsgElement));
		String actualCollectionSaveMsg=collectionName_toast_message.getText();
		System.out.println("CollectionSavetoastMsg ---> "+  actualCollectionSaveMsg );

		 if (actualCollectionSaveMsg.equals(expectedCollectionSaveMsg)) 
		    {
			System.out.println("Message verified successfully");
			} 
		 else 
			{
			System.out.println("Message not matched");
			}	
	}
	
	public void getCollection(WebDriver driver, String collectionName) throws InterruptedException {
		Thread.sleep(5000);
	  String CollectionName_DynamicXPATH = "//p[text()='" + collectionName + "']";
	  
	  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	 WebElement CollectionName_DynamicElement=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CollectionName_DynamicXPATH)));
	 CollectionName_DynamicElement.click();
	 
	 
	 String workflow = "//p[contains(text(),'" + collectionName + "')]/ancestor::div[@class='accordion__button']//div[@data-tooltip-content='Add Workflow']";
	 WebElement workflowxpathElement =wait.until(ExpectedConditions.elementToBeClickable(By.xpath(workflow)));
	 
		Actions actions = new Actions(driver);
		actions.moveToElement(workflowxpathElement).click().perform();
		
	}
	
	public void addWorkflowByUsingStartWithBlackOption(WebDriver driver,String workflowName,String URL) throws InterruptedException {
		Random random=new Random();
	    int ran=random.nextInt(1000);
		
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	   String workflownamewithrandomnumber= workflowName + "_"+ran;
	   String urlwithrandomnumber = URL+"_"+ran;
		StartWithBlank.click();
		Thread.sleep(3000);
		startWithBlankNextButtonElement.click();
		Thread.sleep(3000);
		workFlowNameTextFieldElement.clear();
		workFlowNameTextFieldElement.sendKeys(workflownamewithrandomnumber + ran );
		Thread.sleep(3000);
		workFlowURLTextFieldElement.sendKeys(urlwithrandomnumber + ran);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", workflowSaveButtonElement);
		
		Thread.sleep(10000);
		
		
		
		
	}
}
