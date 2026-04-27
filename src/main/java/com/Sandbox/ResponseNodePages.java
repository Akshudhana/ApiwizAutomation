package com.Sandbox;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResponseNodePages {
	 String ExpectedResponseSavedMsg = "Workflow updated successfully";
	
	   @FindBy(xpath = "//p[text()='Set Response' and @class='color-text-regular fs-12px fw-500']/ancestor::div[@class='border-stroke-section-1px bg-surface-l2 br-4px custom__node-wrapper  position-relative']")
	    private WebElement responseNodeElement;
	    
		@FindBy(xpath = "//div[text()='Select type']/ancestor::div[@class='css-13cymwt-control']/descendant::div[@class='css-1wy0on6']")
	    private WebElement selectTypeDropDownElement;
	    
	    @FindBy(xpath = "//div[text()='JSON']")
	    private WebElement selectTypeAsJsonElement;
	    
	    @FindBy(xpath = "//div[@class='view-lines monaco-mouse-cursor-text']")
	    private WebElement responseBodyPayloadTextFieldElement;
	    
	    @FindBy(xpath = "//p[@class='color-text-regular fs-13px fs-13px fw-500' and text()='Save']")
	    private WebElement responseSaveButtonElement;
	    
	    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
	    private WebElement ActualResponseSaveToastMsg;
	    
	    @FindBy(xpath = "//p[@class='fw-500 fs-13px color-text-heading' and text()='Build']/ancestor::div[@class='flex-row ddHover hz-space-between vt-center w-100 h-36px mainTopSection px-8px']/descendant::div[@class='flex-row hz-space-between vt-center']")
	    private WebElement MainSaveButton;
	    
	    public WebElement getResponseNodeElement() {
		return responseNodeElement;
	}

	   public WebElement getSelectTypeDropDownElement() {
		   return selectTypeDropDownElement;
	   }

	   public WebElement getSelectTypeAsJsonElement() {
		   return selectTypeAsJsonElement;
	   }

	   public WebElement getResponseBodyPayloadTextFieldElement() {
		   return responseBodyPayloadTextFieldElement;
	   }

	   public WebElement getResponseSaveButtonElement() {
		   return responseSaveButtonElement;
	   }

	   public WebElement getActualResponseSaveToastMsg() {
		   return ActualResponseSaveToastMsg;
	   }

	   public WebElement getMainSaveButton() {
		   return MainSaveButton;
	   }
	   
	   
	   
	   public ResponseNodePages(WebDriver driver) {
		   PageFactory.initElements(driver,this);
	   }
	   
	   public void AddResponseNode(WebDriver driver) throws InterruptedException {
		   responseNodeElement.click();
		   
		   Thread.sleep(3000);
		   selectTypeDropDownElement.click();
		   
		   Thread.sleep(3000);
		   selectTypeAsJsonElement.click();
		   
		   Thread.sleep(3000);
		   
		   Actions actions=new Actions(driver);
		   actions.moveToElement(responseBodyPayloadTextFieldElement).click().sendKeys("{\"Response\" : \"successfull\"}").perform();
		   
		   
		   Thread.sleep(3000);
		   actions.moveToElement(responseSaveButtonElement).click().perform();
		   
//		   String ActualResponseSaveMsg =ActualResponseSaveToastMsg.getText();
//		   System.out.println("ResponseSaveToastMsg ---> "+  ActualResponseSaveMsg );
//			 if(ActualResponseSaveMsg.equals(ExpectedResponseSavedMsg)) {
//				    System.out.println("Message verified successfully");
//						} else {
//						    System.out.println("Message not matched");
//						}
			 
			 Thread.sleep(3000);
		    actions.moveToElement(MainSaveButton).click().perform();
//			   String ActualResponseMainSaveMsg =ActualResponseSaveToastMsg.getText();
//			   System.out.println("ResponseSaveToastMsg ---> "+  ActualResponseMainSaveMsg );
//				 if(ActualResponseMainSaveMsg.equals(ExpectedResponseSavedMsg)) {
//					    System.out.println("Message verified successfully");
//							} else {
//							    System.out.println("Message not matched");
//							}
		    
				 Thread.sleep(3000);
		    deployPage deployPage = new deployPage(driver);
		    deployPage.DeployTheWorkflow(driver);
		    
		   
		  
	   }
}
