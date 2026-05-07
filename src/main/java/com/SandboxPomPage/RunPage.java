package com.SandboxPomPage;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RunPage {


	@FindBy(xpath = "//p[@class='fw-500 fs-13px color-text-heading' and text()='Run']")
	private WebElement run;
	
	@FindBy(xpath = "//p[text()='Request']/ancestor::div[@class='h-36px flex-row vt-center gap-8px hz-space-between px-8px py-4px border-bottom-stroke-subsection-1px']/descendant::div[@class='css-1wy0on6']")
    private WebElement SelectHostToRunDropDown;

	@FindBy(xpath = "//div[text()='akshatha-dev']")
	private WebElement StageHostName;
	
	@FindBy(xpath = "//div[text()='acme-team-production']")
	private WebElement ProdHostName;


	@FindBy(xpath = "//div[@class='cursor-pointer h-32px flex-row vt-center w-32px gap-8px hz-center']")
	private WebElement RunDropDown;
	
	@FindBy(xpath = "//div[text()='Run with Events']")
	private WebElement RunWithEvent;
	
	@FindBy(xpath = "//p[text()='View Events' and @class='color-text-regular fs-13px fs-13px fw-500']")
	private WebElement ViewEvents;
	
	public WebElement getRun() {
		return run;
	}
    
	public WebElement getSelectHostToRunDropDown() {
		return SelectHostToRunDropDown;
	}

	public WebElement getStageHostName() {
		return StageHostName;
	}
	
	public WebElement getProdHostName() {
		return ProdHostName;
	}


	public WebElement getRunDropDown() {
		return RunDropDown;
	}

	public WebElement getRunWithEvent() {
		return RunWithEvent;
	}

	public WebElement getViewEvents() {
		return ViewEvents;
	}
	
	public RunPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void SatgeRunWorkflow(WebDriver driver) throws InterruptedException {
		Actions actions =new Actions(driver);
		actions.moveToElement(run).click().perform();
		
		
		Thread.sleep(3000);
		SelectHostToRunDropDown.click();
		
		Thread.sleep(3000);
		StageHostName.click();
		

		Thread.sleep(3000);
		actions.moveToElement(RunDropDown).click().perform();
		

		Thread.sleep(3000);
		actions.moveToElement(RunWithEvent).click().perform();
		
		Thread.sleep(3000);
		actions.moveToElement(ViewEvents).click().perform();
		
		
	}
	
	public void ProdRunWorkflow(WebDriver driver) throws InterruptedException {
		Actions actions =new Actions(driver);
		actions.moveToElement(run).click().perform();
		
		
		Thread.sleep(3000);
		SelectHostToRunDropDown.click();
		
		Thread.sleep(3000);
		ProdHostName.click();
		
		Thread.sleep(3000);
		actions.moveToElement(RunDropDown).click().perform();
		

		Thread.sleep(3000);
		actions.moveToElement(RunWithEvent).click().perform();
		
		Thread.sleep(3000);
		actions.moveToElement(ViewEvents).click().perform();
		
		
	}
	
}
