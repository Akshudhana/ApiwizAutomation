package com.Sandbox;

import java.sql.Driver;

import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.PomPages.LoginPage;
import com.PomPages.RestApiPage;
import com.SandboxPomPage.AddCollection;
import com.SandboxPomPage.ResponseNodePages;
import com.SandboxPomPage.RunPage;
import com.SandboxPomPage.deployPage;

public class RestApiNodeTest extends BaseClass{
	
	@Test
	public void RestApi() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
//		loginPage.LoginToApp("https://acme-team-production.apiwiz.io/auth","AkshathaSM", "L8#kR!9vPz@4tQ2sAD512");
		loginPage.LoginToApp("https://akshatha-dev.apiwiz.io/", "TeamUserAnkit", "Devuseraccount@8");
		
		AddCollection collection=new AddCollection(driver);
		String collectionname = collection.generateCollectionName("RestApi");
		
		collection.createCollection(driver, collectionname);
		
		collection.getCollection(driver, collectionname);
		
		collection.addWorkflowByUsingStartWithBlackOption(driver, collectionname, "restapi");
		
		
		RestApiPage restApiNodeTest=new RestApiPage(driver);
		restApiNodeTest.AddRestApiNodeToServiceCallout(driver,"RestApi", "RestApi", "akshatha-dev-gnhn.apiwiz.io", "restapi");
		
		String responseString ="\"response\" : \"Successfull\"}";
		
		ResponseNodePages responseNodePages=new ResponseNodePages(driver);
		responseNodePages.AddResponseNode(driver, responseString);
		
		deployPage deployPage = new deployPage(driver);
		deployPage.StageDeployTheWorkflow(driver);
//		deployPage.ProdDeployTheWorkflow(driver);
		
		RunPage runPage = new RunPage(driver);
		runPage.SatgeRunWorkflow(driver);
//		runPage.ProdRunWorkflow(driver);
		
	}
}
