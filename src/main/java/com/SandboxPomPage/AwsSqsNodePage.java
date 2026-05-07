package com.SandboxPomPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AwsSqsNodePage {
	 String ExpectedSqsNodeSavedMsg = "Workflow updated successfully";
		
//	@FindBy(xpath = "//button[@class='vertex-edge-add-button w-14px h-14px flex-center cursor-pointer p-8px']")
//   private WebElement serviceCallOutAddButtoneElement;
   
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
   
   public WebElement getWorkflowUpdatedSuccessfullytToastMessagElement() {
		return workflowUpdatedSuccessfullytToastMessagElement;
	}

	@FindBy(xpath = "//div[text()='Workflow updated successfully']")
   private WebElement workflowUpdatedSuccessfullytToastMessagElement;
   
   @FindBy(xpath = "//input[@id='sqs-connection-mode-manual']")
   private WebElement manualConnectionRadioButtonElement;


	@FindBy(xpath = "//input[@placeholder='Enter Access Key']")
   private WebElement accessKeyTextFieldElement;
   
   @FindBy(xpath = "//input[@placeholder='Enter Secret Key']")
   private WebElement secretKeyTextFieldElement;
   
   @FindBy(xpath = "//input[@placeholder='Enter Region']")
   private WebElement regionTextFieldElement;
   
   @FindBy(xpath = "//input[@placeholder='Enter Queue Name']")
   private WebElement queueNameTextFieldElement;
   
   @FindBy(xpath = "//input[@placeholder='Enter Queue URL']")
   private WebElement queueURLTextFieldElement;
   
   @FindBy(xpath = "//div[text()='Queue Type']/ancestor::div[@class='form__input border-bottom-stroke-subsection-1px flex-row w-100 text-left flex-center br-5px false']/descendant::div[@class='css-1wy0on6']")
   private WebElement queueTypeDropDownElement;
   
   @FindBy(xpath = "//div[text()='Standard']")
   private WebElement standardQueueTypElement;
   
   @FindBy(xpath = "//div[text()='FIFO']")
   private WebElement fifoQueueTypeElement;
   
   @FindBy(xpath = "//input[@placeholder='Message Body']")
   private WebElement messageBodyElement;
   
   @FindBy(xpath = "//input[@placeholder='Enter Delay Seconds']")
   private WebElement delaySecondElement;
   
   @FindBy(xpath = "//input[@placeholder='Group ID']")
   private WebElement messageGroupIDElement;
   
   @FindBy(xpath = "//input[@placeholder='Deduplication ID']")
   private WebElement deduplicatioIDElement;
   
   @FindBy(xpath = "//span[@class='switch-slider']")
   private WebElement storeResponseToggleButtonElement;
  

	@FindBy(xpath = "//input[@placeholder='Key']")
   private WebElement messageAttributesKeyTextFieldElement;
   
   @FindBy(xpath = "//input[@placeholder='Value']")
   private WebElement messageAttributesValueTextFieldElement;
   
	@FindBy(xpath = "//input[@placeholder='Enter Target Variable']")
   private WebElement targetVariablElement;
   
	

//   public WebElement getServiceCallOutAddButtoneElement() {
//		return serviceCallOutAddButtoneElement;
//	}

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
	
   public WebElement getManualConnectionRadioButtonElement() {
		return manualConnectionRadioButtonElement;
	}

	public WebElement getSecretKeyTextFieldElement() {
		return secretKeyTextFieldElement;
	}

	public WebElement getRegionTextFieldElement() {
		return regionTextFieldElement;
	}

	public WebElement getQueueNameTextFieldElement() {
		return queueNameTextFieldElement;
	}

	public WebElement getQueueURLTextFieldElement() {
		return queueURLTextFieldElement;
	}

	public WebElement getQueueTypeDropDownElement() {
		return queueTypeDropDownElement;
	}

	public WebElement getStandardQueueTypElement() {
		return standardQueueTypElement;
	}

	public WebElement getFifoQueueTypeElement() {
		return fifoQueueTypeElement;
	}

	public WebElement getMessageAttributesKeyTextFieldElement() {
		return messageAttributesKeyTextFieldElement;
	}

	public WebElement getMessageAttributesValueTextFieldElement() {
		return messageAttributesValueTextFieldElement;
	}

	public String getExpectedSqsNodeSavedMsg() {
		return ExpectedSqsNodeSavedMsg;
	}

	public WebElement getActualSqsNodeSaveToastMsg() {
		return ActualSqsNodeSaveToastMsg;
	}

	public WebElement getAccessKeyTextFieldElement() {
		return accessKeyTextFieldElement;
	}

	public WebElement getStoreResponseToggleButtonElement() {
		return storeResponseToggleButtonElement;
	}
	
   public WebElement getMessageBodyElement() {
		return messageBodyElement;
	}

	public WebElement getMessageGroupIDElement() {
		return messageGroupIDElement;
	}

	public AwsSqsNodePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getTargetVariablElement() {
		return targetVariablElement;
	}
	
	public void CreatingAWSSQSNodeUsingConnectorConneaction(WebDriver driver,String aws,String awsSqsName,String awsSqsMessageBody,String awsSqsMessageGroupID) throws InterruptedException 
	{
		
		AddServiceCalloutPage addServiceCalloutPage=new AddServiceCalloutPage(driver);
		addServiceCalloutPage.AddServiceCallout(driver);
		
//		Actions actions=new Actions(driver);
//		actions.moveToElement(serviceCallOutAddButtoneElement).click().perform();
		
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
	
	
	
	
	public void createAWSSQSNodeManualConnectionStandardQueue(WebDriver driver,String aws,String awsSqsName, String accessKey,String secretKey,String region,String queueName,String queueURL, String messageBody,String deplaySecond, String targetVariable, String messageAttributeKey,String messageAttributeValue) throws InterruptedException 
	{
		Actions actions=new Actions(driver);
		
//		actions.moveToElement(serviceCallOutAddButtoneElement).click().perform();
		
		AddServiceCalloutPage addServiceCalloutPage=new AddServiceCalloutPage(driver);
		addServiceCalloutPage.AddServiceCallout(driver);
		
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
		actions.moveToElement(manualConnectionRadioButtonElement).click().perform();
		
		Thread.sleep(3000);
		accessKeyTextFieldElement.sendKeys(accessKey);
		
		Thread.sleep(3000);
		secretKeyTextFieldElement.sendKeys(secretKey);
		
		Thread.sleep(3000);
		regionTextFieldElement.sendKeys(region);
		
		Thread.sleep(3000);
		queueNameTextFieldElement.sendKeys(queueName);
		
		Thread.sleep(3000);
		queueURLTextFieldElement.sendKeys(queueURL);
		
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", standardQueueTypElement);
		
		Thread.sleep(3000);
		messageBodyElement.sendKeys(messageBody);
		
		Thread.sleep(3000);
		delaySecondElement.sendKeys(deplaySecond);
		
		Thread.sleep(3000);
		storeResponseToggleButtonElement.click();
		
		Thread.sleep(3000);
		targetVariablElement.sendKeys(targetVariable);
		   
		Thread.sleep(3000);
		messageAttributesKeyTextFieldElement.sendKeys(messageAttributeKey);
		
		Thread.sleep(3000);
		messageAttributesValueTextFieldElement.sendKeys(messageAttributeValue);
		
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", awsSqsNodeSaveButtonElement);
		
		Thread.sleep(5000);
		String ActualSqsNodeSaveMsg=workflowUpdatedSuccessfullytToastMessagElement.getText();
		 System.out.println("SqsNodeSaveToastMs ---> "+  ActualSqsNodeSaveMsg );
		 if(ActualSqsNodeSaveMsg.equals(ExpectedSqsNodeSavedMsg)) 
		 {
			    System.out.println("Message verified successfully");
					} else {
					    System.out.println("Message not matched");
					}	
	
	}
	
	
	public void validateAwsSqsResponseMessageInExecutionLogs(WebDriver driver,String awsSqsName) {
		
		AddCollection collection = new AddCollection(driver);
		collection.generateCollectionName(awsSqsName);
		

		String AWSSQSResponseMessageInExecutionLogs="//div[@title='"+ awsSqsName +"']/ancestor::div[@class='ps-px flex-row vt-center gap-6px max-w-60']/descendant::div[@class='fs-12px fw-500 color-text-regular text-truncate-1 flex-row vt-center gap-6px']";
		
		
		WebElement GetAWSSQSResponseMessageInExecutionLogs=driver.findElement(By.xpath(AWSSQSResponseMessageInExecutionLogs));
		
		String response=GetAWSSQSResponseMessageInExecutionLogs.getText();
		
		if ("Message pushed to AWS SQS Producer successfully".equals(response)) {
		    System.out.println("Success");
		} 
		else if ("Failed to push message to AWS SQS Producer".equals(response)) {
		    System.out.println("Failure");
		} 
		else {
		    System.out.println("Unknown response: " + response);
		}
	}
}
