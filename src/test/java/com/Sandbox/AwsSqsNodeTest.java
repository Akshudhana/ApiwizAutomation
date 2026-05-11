package com.Sandbox;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.PomPages.LoginPage;
import com.SandboxPomPage.AddCollection;
import com.SandboxPomPage.AddServiceCalloutPage;
import com.SandboxPomPage.AwsSqsNodePage;
import com.SandboxPomPage.NavigatingToSandoxPage;
import com.SandboxPomPage.ResponseNodePages;
import com.SandboxPomPage.RunPage;
import com.SandboxPomPage.deployPage;

@Listeners(com.GenericUtility.ListImpClassA.class)
public class AwsSqsNodeTest extends BaseClass{

	@Test
public void addAWSSQSNodeUsingConnectorConneaction() throws InterruptedException{
  System.out.print("driver----->"+ driver);
  LoginPage loginPage = new LoginPage(driver);
  loginPage.AkshathadevStageLogin();
//  loginPage.AcmeteamProductionLogin();
	
	NavigatingToSandoxPage navigatingToSandox=new NavigatingToSandoxPage(driver);
	navigatingToSandox.navigatingToSandbox(driver);

    AddCollection addCollection = new AddCollection(driver);
	String collectionName = addCollection.generateCollectionName("ApiAwsSqsCollection");
	
	addCollection.createCollection(driver, collectionName);
	
	addCollection.getCollection(driver, collectionName);
	addCollection.addWorkflowByUsingStartWithBlackOption(driver, "sampleawssqssnode", "awssqs");
	
	AwsSqsNodePage aws=new AwsSqsNodePage(driver);
	aws.CreatingAWSSQSNodeUsingConnectorConneaction(driver,"aws", "AWS_SQL_NAME", "aws mesage", "messageID");
	
	String responseString= "{\"Response\" : \"{Successfull\"}";
	
	ResponseNodePages responseNodePages=new ResponseNodePages(driver);
	responseNodePages.AddResponseNode(driver, responseString);
	
	deployPage deployPage = new deployPage(driver);
	deployPage.StageDeployTheWorkflow(driver);
//	deployPage.ProdDeployTheWorkflow(driver);
	
	RunPage runPage = new RunPage(driver);
			runPage.SatgeRunWorkflow(driver);
	}
	

	
	@Test
	public void addAWSSQSNodeUsingManualConneaction() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
        loginPage.AkshathadevStageLogin();
        loginPage.AcmeteamProductionLogin();
		
		NavigatingToSandoxPage navigatingToSandox=new NavigatingToSandoxPage(driver);
		navigatingToSandox.navigatingToSandbox(driver);

		AddCollection addCollection = new AddCollection(driver);
		String collectionName = addCollection.generateCollectionName("ApiEnvcollectionasssss");
		
		addCollection.createCollection(driver, collectionName);
		
		addCollection.getCollection(driver, collectionName);
		addCollection.addWorkflowByUsingStartWithBlackOption(driver, "sampleawssqssnode", "awssqs");
		
//		AddServiceCalloutPage addServiceCalloutPage=new AddServiceCalloutPage(driver);
//		addServiceCalloutPage.AddServiceCallout(driver);
		
		AwsSqsNodePage aws=new AwsSqsNodePage(driver);
		String aWSSQSNameString = "AWSSQS_Standard";
		
		aws.createAWSSQSNodeManualConnectionStandardQueue(driver, "aws", aWSSQSNameString, "AKIA24SOXSG7WWTED34A", "O32NvN1CvNZBanMhRVUWhswKWmU+TzL/jNZmrCCE", "us-east-2", "sample-fifo-queue-without-CBD.fifo","https://sqs.us-east-2.amazonaws.com/748563173823/sample-fifo-queue-without-CBD.fifo", "mesagebody", "1", "response_var", "message_key", "message_value");
		
		String responseString= "{\"Response\" : \"{Successfull\"}";
		
		ResponseNodePages responseNodePages=new ResponseNodePages(driver);
		responseNodePages.AddResponseNode(driver, aWSSQSNameString);
		
		deployPage deployPage = new deployPage(driver);
		deployPage.StageDeployTheWorkflow(driver);
//		deployPage.ProdDeployTheWorkflow(driver);
		
		RunPage runPage = new RunPage(driver);
		runPage.SatgeRunWorkflow(driver);
		
		aws.validateAwsSqsResponseMessageInExecutionLogs(driver, aWSSQSNameString);
		
	}
}
