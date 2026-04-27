package com.PomPages;




import java.sql.Driver;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AWSSQSNodePage {
	
	 String ExpectedSqsNodeSavedMsg = "Workflow updated successfully";
	
	@FindBy(xpath = "//button[@class='vertex-edge-add-button w-14px h-14px flex-center cursor-pointer p-8px']")
    private WebElement serviceCallOutAddButtoneElement;
    
    @FindBy(xpath = "//input[@placeholder='Search here ...']")
    private WebElement nodeSerchFieldElement;
    
    @FindBy(xpath = "//p[@class='color-text-regular fs-13px fw-600' and text()='AWS SQS Producer']/ancestor::div[contains(@class,'position-relative overflow-hidden w-100')]")
    private WebElement awsSqsNodeSelectionElement;
    
    @FindBy(xpath = "//div[@class='bg-orange-100 h-42px w-42px br-6px flex-center']/ancestor::div[@class='flex-col br-6px custom__node aws_sqs-node ghosted border-stroke-section-1px w-max-content']")
    private WebElement addAwsSqsNodeElement;
    
    @FindBy(xpath = "//p[@class='color-text-regular fs-12px fw-500' and text()='AWS SQS Producer']/ancestor::div[@class='react-flow__node react-flow__node-vertex nopan selectable draggable']")
    private WebElement navigatingToAwsSqsNode;
    
    @FindBy(xpath = "//input[@placeholder='Enter Name']")
    private WebElement awsSqsNodeNameTextFieldElement;
    
    @FindBy(xpath = "//div[text()='AWS Connector' and @class='text-truncate-1']/ancestor::div[@class='form__input border-bottom-stroke-subsection-1px flex-row w-100 text-left flex-center br-5px false']/descendant::div[@class='css-1wy0on6']")
    private WebElement awsConnectorDetailsDropDownElement;
    
    @FindBy(xpath = "//div[text()='AWS']")
    private WebElement awsSqsNodeConnectorDetailsElement;
    
    @FindBy(xpath = "//input[@placeholder='Message Body']")
    private WebElement awsSqsMessageBodyTextFieldElement;
    
    @FindBy(xpath = "//input[@placeholder='Group ID']")
    private WebElement awsSqsMessageGroupIDTextFieldElement;
    
    @FindBy(xpath = "//p[text()='Save']")
    private WebElement awsSqsNodeSaveButtonElement;
    
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    private WebElement ActualSqsNodeSaveToastMsg;
    
    
    public WebElement getServiceCallOutAddButtoneElement() {
		return serviceCallOutAddButtoneElement;
	}

	public WebElement getNodeSerchFieldElement() {
		return nodeSerchFieldElement;
	}

	public WebElement getAwsSqsNodeSelectionElement() {
		return awsSqsNodeSelectionElement;
	}

	public WebElement getAddAwsSqsNodeElement() {
		return addAwsSqsNodeElement;
	}

	public WebElement getNavigatingToAwsSqsNode() {
		return navigatingToAwsSqsNode;
	}

	public WebElement getAwsSqsNodeNameTextFieldElement() {
		return awsSqsNodeNameTextFieldElement;
	}

	public WebElement getAwsConnectorDetailsDropDownElement() {
		return awsConnectorDetailsDropDownElement;
	}

	public WebElement getAwsSqsNodeConnectorDetailsElement() {
		return awsSqsNodeConnectorDetailsElement;
	}

	public WebElement getAwsSqsMessageBodyTextFieldElement() {
		return awsSqsMessageBodyTextFieldElement;
	}

	public WebElement getAwsSqsMessageGroupIDTextFieldElement() {
		return awsSqsMessageGroupIDTextFieldElement;
	}

	public WebElement getAwsSqsNodeSaveButtonElement() {
		return awsSqsNodeSaveButtonElement;
	}
	
	public AWSSQSNodePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void CreatingAWSSQSNode(WebDriver driver,String aws,String awsSqsName,String awsSqsMessageBody,String awsSqsMessageGroupID) throws InterruptedException 
	{
		
		Actions actions=new Actions(driver);
		actions.moveToElement(serviceCallOutAddButtoneElement).click().perform();
		
		Thread.sleep(3000);
		nodeSerchFieldElement.sendKeys(aws);
		
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", awsSqsNodeSelectionElement);
		
		Thread.sleep(3000);
		addAwsSqsNodeElement.click();
		
		Thread.sleep(3000);
		navigatingToAwsSqsNode.click();
		
		Thread.sleep(3000);
		awsSqsNodeNameTextFieldElement.clear();
		awsSqsNodeNameTextFieldElement.sendKeys(awsSqsName);
		
		Thread.sleep(3000);
		awsConnectorDetailsDropDownElement.click();
		
		Thread.sleep(3000);
		awsSqsNodeConnectorDetailsElement.click();
		
		Thread.sleep(3000);
		awsSqsMessageBodyTextFieldElement.sendKeys(awsSqsMessageBody);
		
		Thread.sleep(3000);
		awsSqsMessageGroupIDTextFieldElement.sendKeys(awsSqsMessageGroupID);
		
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", awsSqsNodeSaveButtonElement);
		
		Thread.sleep(3000);
		String ActualSqsNodeSaveMsg=ActualSqsNodeSaveToastMsg.getText();
		 System.out.println("SqsNodeSaveToastMs ---> "+  ActualSqsNodeSaveMsg );
		 if(ActualSqsNodeSaveMsg.equals(ExpectedSqsNodeSavedMsg)) {
			    System.out.println("Message verified successfully");
					} else {
					    System.out.println("Message not matched");
					}	
		
	}
    


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	

}
