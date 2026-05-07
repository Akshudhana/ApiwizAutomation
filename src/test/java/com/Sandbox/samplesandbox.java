package com.Sandbox;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class samplesandbox {
	

// @Test
//	public void sampletest() {
//		ChromeDriver driver =new ChromeDriver();
//		  driver.manage().window().maximize();
//		  driver.get("https://akshatha-dev.apiwiz.io/");
//		      
//		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}

		@Test
		public void CreateWorkflowByAddingAWSSQSNode() throws InterruptedException {
		  ChromeDriver driver =new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://akshatha-dev.apiwiz.io/");
		      
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  
		  Random random=new Random();
		     int randomnum= random.nextInt();
		      
		  WebElement usernameElement =driver.findElement(By.xpath("//input[@placeholder='Enter Username']"));
		  usernameElement.sendKeys("TeamUserAnkiassdfst");
		      
		  WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
		  Password.sendKeys("Devuseraccount@8");
		    		  
		  WebElement login =driver.findElement(By.xpath("//p[@class='text-white dfs-13px fw-500' and text()='Log in']"));
		 login.click();
		    		  
		 WebElement Sandbox =driver.findElement(By.xpath("//p[@class='menuItem__path fs-14px fw-500 text-nowrap ' and text()='API Sandbox']/ancestor::div[@class='flex-row vt-center']"));
		 Sandbox.click();
		 
		 Thread.sleep(10000);
		      
	     WebElement addCollection =driver.findElement(By.xpath("//div[@data-tooltip-content='Add Collection']"));
		 Actions action=new Actions(driver);
	     action.moveToElement(addCollection).click().perform();
		      
	     Thread.sleep(3000);
	    
	     String collectionName = "ApiEnvcollection" + randomnum;
	     
		 WebElement AddCollectionName = driver.findElement(By.xpath("//input[@placeholder='Enter Name' or @class='undefined  isDefault undefined null null w-100 formInputTag']"));
		 AddCollectionName.sendKeys(collectionName);
		     
		 System.out.println(collectionName);
		 
		 Thread.sleep(3000);
			   
		 WebElement SaveButton = driver.findElement(By.xpath("//p[text()='Overview' and @class='color-text-regular fs-16px fw-600']/ancestor::div[@class='flex-row vt-center hz-space-between px-8px py-6px h-36px border-bottom-stroke-section-1px']//descendant::*[name()='svg' and @class='color-text-regular'][2]"));
		 action.moveToElement(SaveButton).click().perform();

		 String expectedCollectionSaveMsg = "Collection created successfully";

		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		 WebElement CollectionSavetoastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
		     By.xpath("//div[@class='Toastify__toast-body']")
		 ));

		 String actualMsg = CollectionSavetoastMsg.getText();

		 System.out.println("CollectionSavetoastMsg ---> "+  actualMsg );

		 if (actualMsg.equals(expectedCollectionSaveMsg)) {
			System.out.println("Message verified successfully");
			} else {
			System.out.println("Message not matched");
			}

		
		 WebElement collectionClick = driver.findElement(By.xpath("//p[text()='" + collectionName+ "']"));
		 collectionClick.click();
		     
		 Thread.sleep(3000);
	     
	     WebElement AddWorkflow = driver.findElement(
	     By.xpath("//p[contains(text(),'" + collectionName + "')]/ancestor::div[@class='accordion__button']//div[@data-tooltip-content='Add Workflow']"));
	     action.moveToElement(AddWorkflow).click().perform();
			   
		 WebElement StartWithBlank = driver.findElement(By.xpath("//p[@class='text-truncate-1 fs-13px fw-500 color-text-regular' and text()='Start with Blank Template']/ancestor::div[@class='bg-surface-l1 flex-row vt-center hz-space-between gap-6px zIndex-2 pr-8px']/descendant::div[@class='flex-row vt-center form__radio cursor-pointer min-w-0']"));
		 StartWithBlank.click();
		   
		 Thread.sleep(3000);
		   
		 WebElement StartWithBlankNextButton= driver.findElement(By.xpath("//p[@class='fw-500 fs-13px text-white' and text()='Next']/ancestor::div[@class='position-relative overflow-hidden btn-primary cursor-pointer']"));
		 StartWithBlankNextButton.click();
		    
		 Thread.sleep(3000);
			   
		 WebElement WorkFlowName=driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
		 WorkFlowName.clear();
		 WorkFlowName.sendKeys("AwsSqsNodeWorkflow" + randomnum);
		   
		 Thread.sleep(3000);
		   
		 WebElement WorkflowURL=driver.findElement(By.xpath("//input[@placeholder='Enter URL']"));
		 WorkflowURL.sendKeys("Aws_sqs_node_sample_urlss" + randomnum);
		   
		 Thread.sleep(3000);
		 
		 WebElement WorkflowSaveButton= driver.findElement(By.xpath("//p[@class='color-text-regular fs-13px fs-13px fw-500' and text()='Save']"));
		 js.executeScript("arguments[0].click();", WorkflowSaveButton);
		    
		 
		 String ExpectedWorkflowSaveMsg = "Workflow updated successfully";
		 
		 WebElement WorkflowSaveToastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
			     By.xpath("//div[@class='Toastify__toast-body']")
			 ));
		 String ActualWorkflowSaveToastMsg = WorkflowSaveToastMessage.getText();
		 System.out.println("WorkflowSaveToastMessage ---> "+  ActualWorkflowSaveToastMsg );
		 if(ActualWorkflowSaveToastMsg.equals(ExpectedWorkflowSaveMsg)) {
			 System.out.println("Message verified successfully");
		 }
		 else {
			 System.out.println("Message not matched");
		 }
		 
		 Thread.sleep(10000);
		  
		 WebElement ServiceCallOutAddButton= driver.findElement(By.xpath("//button[@class='vertex-edge-add-button w-14px h-14px flex-center cursor-pointer p-8px']"));
		 action.moveToElement(ServiceCallOutAddButton).click().perform();
		    
		    
		 Thread.sleep(3000);
		  
		 WebElement NodeSerchField=driver.findElement(By.xpath("//input[@placeholder='Search here ...']"));
		 NodeSerchField.sendKeys("Aws");
		   
		 Thread.sleep(3000);
		   
		 WebElement AWSSQS_node= driver.findElement(By.xpath("//p[@class='color-text-regular fs-13px fw-600' and text()='AWS SQS Producer']/ancestor::div[contains(@class,'position-relative overflow-hidden w-100')]"));
		 js.executeScript("arguments[0].click();", AWSSQS_node);
		  
		 Thread.sleep(3000);
		  
		 WebElement Add_AwsSqsNode=driver.findElement(By.xpath("//div[@class='bg-orange-100 h-42px w-42px br-6px flex-center']/ancestor::div[@class='flex-col br-6px custom__node aws_sqs-node ghosted border-stroke-section-1px w-max-content']"));
		 Add_AwsSqsNode.click();
		  
		 Thread.sleep(3000);
		  
		 WebElement NavigatingToAwsSqsNode =driver.findElement(By.xpath("//p[@class='color-text-regular fs-12px fw-500' and text()='AWS SQS Producer']/ancestor::div[@class='react-flow__node react-flow__node-vertex nopan selectable draggable']"));
		 NavigatingToAwsSqsNode.click();
		   
		 Thread.sleep(3000);
		   
		 WebElement AwsSqsNodeName =driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
		 AwsSqsNodeName.clear();
		 AwsSqsNodeName.sendKeys("AWS_SQL_NAME");
		 
		 WebElement AWS_ConnectorDetailsDropDown =driver.findElement(By.xpath("//div[text()='AWS Connector' and @class='text-truncate-1']/ancestor::div[@class='form__input border-bottom-stroke-subsection-1px flex-row w-100 text-left flex-center br-5px false']/descendant::div[@class='css-1wy0on6']"));
		 AWS_ConnectorDetailsDropDown.click();
		  
		 Thread.sleep(3000);
		 
		 WebElement Connector=driver.findElement(By.xpath("//div[text()='AWS']"));
		 Connector.click();
		 
		 Thread.sleep(3000);
		 
		 WebElement messageBody =driver.findElement(By.xpath("//input[@placeholder='Message Body']"));
		 messageBody.sendKeys("Messagey");
		 
		 Thread.sleep(3000);
		 
		 WebElement MessageGroupID=driver.findElement(By.xpath("//input[@placeholder='Group ID']"));
		 MessageGroupID.sendKeys("messageIDt");
		 
		 Thread.sleep(3000);
		 
		 WebElement AWS_SQS_Node_saveButton=driver.findElement(By.xpath("//p[text()='Save']"));
		 js.executeScript("arguments[0].click();", AWS_SQS_Node_saveButton);
	 
		 Thread.sleep(3000);
		 
		 
		 String expectedSqsNodeSavedMsg = "Workflow updated successfully";
		 WebElement ActualSqsNodeSaveToastMsg =driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		 String ActualSqsNodeSaveMsg =ActualSqsNodeSaveToastMsg.getText();
		 System.out.println("SqsNodeSaveToastMs ---> "+  ActualSqsNodeSaveMsg );
		 if(ActualSqsNodeSaveMsg.equals(expectedSqsNodeSavedMsg)) {
			    System.out.println("Message verified successfully");
					} else {
					    System.out.println("Message not matched");
					}
		 
		 
		 WebElement ResponseNode =driver.findElement(By.xpath("//p[text()='Set Response' and @class='color-text-regular fs-12px fw-500']/ancestor::div[@class='border-stroke-section-1px bg-surface-l2 br-4px custom__node-wrapper  position-relative']"));
		 ResponseNode.click();
		 
		 Thread.sleep(3000);
		 
		 
		 WebElement SelectTypeDropDown = driver.findElement(By.xpath("//div[text()='Select type']/ancestor::div[@class='css-13cymwt-control']/descendant::div[@class='css-1wy0on6']"));
		 SelectTypeDropDown.click();
		 
		 Thread.sleep(10);
		 
		 WebElement SelectTypeAsJson = driver.findElement(By.xpath("//div[text()='JSON']"));
		 SelectTypeAsJson.click();
		 
		 Thread.sleep(3000);
		 
		 WebElement ResponseBodyField =driver.findElement(By.xpath("//div[@class='view-lines monaco-mouse-cursor-text']"));
//		 ResponseBodyField.click();
		 action.moveToElement(ResponseBodyField).click().sendKeys("{\"Response\" : \"successfull\"}").perform();
		 
		 Thread.sleep(3000);
		 
		 WebElement ResponseSaveButton = driver.findElement(By.xpath("//p[@class='color-text-regular fs-13px fs-13px fw-500' and text()='Save']"));
		 action.moveToElement(ResponseSaveButton).click().perform();
		 
		 Thread.sleep(3000);
		 
		 String expectedResponseSavedMsg = "Workflow updated successfully";
		 WebElement ActualResponseSaveToastMsg =driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		 String ActualResponseSaveMsg =ActualResponseSaveToastMsg.getText();
		 System.out.println("ResponseSaveToastMsg ---> "+  ActualResponseSaveMsg );
		 if(ActualResponseSaveMsg.equals(expectedResponseSavedMsg)) {
			    System.out.println("Message verified successfully");
					} else {
					    System.out.println("Message not matched");
					}
		 
		 
		 WebElement MainSaveButton = driver.findElement(By.xpath("//p[@class='fw-500 fs-13px color-text-heading' and text()='Build']/ancestor::div[@class='flex-row ddHover hz-space-between vt-center w-100 h-36px mainTopSection px-8px']/descendant::div[@class='flex-row hz-space-between vt-center']"));
		 action.moveToElement(MainSaveButton).click().perform();
		 
		 Thread.sleep(3000);
		 
		 String expectedMainSavedMsg = "Workflow updated successfully";
		 WebElement ActualMainSaveToastMsg =driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		 String ActualMainSaveMsg =ActualMainSaveToastMsg.getText();
		 System.out.println("MainSaveToastMsg ---> "+  ActualMainSaveMsg );
		 if(ActualMainSaveMsg.equals(expectedMainSavedMsg)) {
			    System.out.println("Message verified successfully");
					} else {
					    System.out.println("Message not matched");
					}
		 
		 
		 WebElement Deploy= driver.findElement(By.xpath("//div[@data-tooltip-content='Deploy']"));
		 action.moveToElement(Deploy).click().perform();
		 
		 Thread.sleep(3000);
		 
		 WebElement VertualHostDropdown = driver.findElement(By.xpath("//div[@class='text-truncate-1' and text()='Virtual Host']/ancestor::div[@class='form__input border-bottom-stroke-subsection-1px flex-row w-100 text-left flex-center br-5px undefined']/descendant::div[@class='css-1wy0on6']"));
		 VertualHostDropdown.click();
		 
		 Thread.sleep(3000);
		 
		 
		 WebElement VertualHostNameSelect = driver.findElement(By.xpath("//div[text()='akshatha-dev']"));
		 VertualHostNameSelect.click();
		 
		 Thread.sleep(3000);
		 
		 
		 WebElement MainDeployButton = driver.findElement(By.xpath("//p[@class='fs-13px fw-600 text-white' and text()='Deploy']"));
		 action.moveToElement(MainDeployButton).click().perform();
		 
//		 String expectedMainDeploySavedMsg = "Proxy deployed successfully";
//		 WebElement ActualMainDeploySaveToastMsg =driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
//		 String ActualMainDeploySaveMsg =ActualMainDeploySaveToastMsg.getText();
//		 System.out.println("ActualMainDeploySaveToastMsg ---> "+  ActualMainDeploySaveMsg );
//		 if(ActualMainDeploySaveMsg.equals(expectedMainDeploySavedMsg)) {
//			    System.out.println("Message verified successfully");
//					} else {
//					    System.out.println("Message not matched");
//					}
		 
		 
		 Thread.sleep(10000);
		 
		 WebElement Run=driver.findElement(By.xpath("//p[@class='fw-500 fs-13px color-text-heading' and text()='Run']"));
		 action.moveToElement(Run).click().perform();
		 
		 
		 Thread.sleep(3000);
		 
		 WebElement SelectHostToRunDropDown =driver.findElement(By.xpath("//p[text()='Request']/ancestor::div[@class='h-36px flex-row vt-center gap-8px hz-space-between px-8px py-4px border-bottom-stroke-subsection-1px']/descendant::div[@class='css-1wy0on6']"));
		 SelectHostToRunDropDown.click();
		 //	 js.executeScript("arguments[0].click();", SelectHostToRunDropDown);
		 
		 Thread.sleep(3000);
		 
		 WebElement Host=driver.findElement(By.xpath("//div[text()='akshatha-dev']"));
		 Host.click();
		 
		 Thread.sleep(3000);
		 
		 WebElement RunDropDown= driver.findElement(By.xpath("//div[@class='cursor-pointer h-32px flex-row vt-center w-32px gap-8px hz-center']"));
		 action.moveToElement(RunDropDown).click().perform();
		 
		 Thread.sleep(3000);
		 
		 WebElement RunWithEvent =driver.findElement(By.xpath("//div[text()='Run with Events']"));
		 action.moveToElement(RunWithEvent).click().perform();
		 
		 
		 
		 WebElement ViewEvents =driver.findElement(By.xpath("//p[text()='View Events' and @class='color-text-regular fs-13px fs-13px fw-500']"));
		 action.moveToElement(ViewEvents).click().perform();
		 
		 String ExpectedMessagePushedToAWSSQSProducerSuccessfullyMessage = "Message pushed to AWS SQS Producer successfully";
		 WebElement MessagePushedToAWSSQSProducerSuccessfullyMessage=driver.findElement(By.xpath("//div[text()='Message pushed to AWS SQS Producer successfully']"));
		 String ActualMessagePushedToAWSSQSProducerSuccessfullyMessage =MessagePushedToAWSSQSProducerSuccessfullyMessage.getText();
		 System.out.println("MessagePushedToAWSSQSProducerSuccessfullyMessage ---> "+  ActualMessagePushedToAWSSQSProducerSuccessfullyMessage );
		 if(ActualMessagePushedToAWSSQSProducerSuccessfullyMessage.equals(ExpectedMessagePushedToAWSSQSProducerSuccessfullyMessage)) {
			    System.out.println("Message verified successfully");
					} else {
					    System.out.println("Message not matched");
					}
		 
		 WebElement ToViewTheAWSSQSNodeDetailsInExecutionLog=driver.findElement(By.xpath("//div[text()='Message pushed to AWS SQS Producer successfully']/ancestor::div[@class='h-33px px-8px flex-row hz-space-between vt-center hover-bg-surface-ground-hover border-bottom-stroke-subsection-1px cursor-pointer']/descendant::div[@class='ripple-btn'][1]"));
		 ToViewTheAWSSQSNodeDetailsInExecutionLog.click();
		 
		 
		 String ExpectedAWSSQSPageName = "AWS SQS";
		 WebElement AwsSqsDetailsPage=driver.findElement(By.xpath("//p[text()='AWS SQS']"));
		 String ActualAWSSQSDetailsPage = AwsSqsDetailsPage.getText();
		 System.out.println("ExpectedAWSSQSPageName ---> "+  ActualAWSSQSDetailsPage );
		 if(ActualAWSSQSDetailsPage.equals(ExpectedAWSSQSPageName)) {
			 System.out.println("AWS SQS node details are displayed successfully");
			} else {
				System.out.println("AWS SQS node details are not displayed successfully");
			}
		 
		 driver.close();
		}       
	       
	}

