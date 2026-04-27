package com.Sandbox;


import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.PomPages.AWSSQSNodePage;
import com.PomPages.LoginPage;


public class awsSqsNode extends BaseClass{


	@Test
public void testclassexecution() throws InterruptedException{
  System.out.print("driver----->"+ driver);
  LoginPage loginPage = new LoginPage(driver);
	loginPage.LoginToApp("TeamUserAnkit", "Devuseraccount@8");


	AddCollection addCollection = new AddCollection(driver);
	String collectionName = addCollection.generateCollectionName("ApiEnvcollectionasssss");
	
	Thread.sleep(3000);
	
	addCollection.createCollection(driver, collectionName);
	
	addCollection.getCollection(driver, collectionName);
	addCollection.addWorkflowByUsingStartWithBlackOption(driver, "sampleawssqssnode", "awssqs");
	
	AWSSQSNodePage aws=new AWSSQSNodePage(driver);
	aws.CreatingAWSSQSNode(driver,"aws", "AWS_SQL_NAME", "aws mesage", "messageID");
	
	ResponseNodePages responseNodePages=new ResponseNodePages(driver);
	responseNodePages.AddResponseNode(driver);
	
	RunPage runPage = new RunPage(driver);
			runPage.RunWorkflow(driver);
	
	}
	


}
