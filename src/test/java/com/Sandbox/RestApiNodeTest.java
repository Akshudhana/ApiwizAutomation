package com.Sandbox;

import org.testng.annotations.Test;
import java.sql.Driver;

import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.PomPages.LoginPage;
import com.PomPages.RestApiPage;
import com.SandboxPomPage.AddCollection;
import com.SandboxPomPage.AddServiceCalloutPage;
import com.SandboxPomPage.NavigatingToSandoxPage;
import com.SandboxPomPage.ResponseNodePages;
import com.SandboxPomPage.RunPage;
import com.SandboxPomPage.deployPage;

public class RestApiNodeTest extends BaseClass{
	
	@Test
	public void RestApi() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
        loginPage.AkshathadevStageLogin();
//        loginPage.AcmeteamProductionLogin();
		
		NavigatingToSandoxPage navigatingToSandoxPage=new NavigatingToSandoxPage(driver);
		navigatingToSandoxPage.navigatingToSandbox(driver);
		
		AddCollection collection=new AddCollection(driver);
		String collectionname = collection.generateCollectionName("RestApi");
		
		collection.createCollection(driver, collectionname);
		
		collection.getCollection(driver, collectionname);
		
		collection.addWorkflowByUsingStartWithBlackOption(driver, collectionname, "restapi");
		
		AddServiceCalloutPage addServiceCalloutPage=new AddServiceCalloutPage(driver);
		addServiceCalloutPage.AddServiceCallout(driver);
		
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
