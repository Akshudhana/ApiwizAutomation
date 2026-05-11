package com.Sandbox;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.GenericUtility.BaseClass;
import com.PomPages.LoginPage;
import com.SandboxPomPage.AddCollection;
import com.SandboxPomPage.AddServiceCalloutPage;
import com.SandboxPomPage.EnvironmentPage;
import com.SandboxPomPage.JsonToXmlNodePage;
import com.SandboxPomPage.NavigatingToSandoxPage;
import com.SandboxPomPage.ResponseNodePages;
import com.SandboxPomPage.RunPage;
import com.SandboxPomPage.deployPage;

@Listeners(com.GenericUtility.ListImpClassA.class)
public class JsonToXmlTest extends BaseClass{
	
	@Test
	public void AddJsonToXmlNode() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
        loginPage.AkshathadevStageLogin();
//        loginPage.AcmeteamProductionLogin();
		
		Thread.sleep(10000);
		
		NavigatingToSandoxPage navigatingToSandox=new NavigatingToSandoxPage(driver);
		navigatingToSandox.navigatingToSandbox(driver);
		
		String envName = "env";
		String envKey="payload";
		String targetvar = "targetvar";
		
		EnvironmentPage environmentPage=new EnvironmentPage(driver);
		String createdEnvName=environmentPage.CreateEnvironment(driver, envName, "Env_desc", envKey, "{\"User\" : \"admin\"}");
		
		AddCollection addCollection = new AddCollection(driver);
		String collectionName = addCollection.generateCollectionName("JsonToXmlConverter");
		
		addCollection.createCollection(driver, collectionName);
		
		addCollection.getCollection(driver, collectionName);
		addCollection.CreateWorkflowByAddingEnvironment(driver, "JsonToXml", "JsonToXml", createdEnvName);
		
		Thread.sleep(3000);
		
		AddServiceCalloutPage addServiceCalloutPage=new AddServiceCalloutPage(driver);
		addServiceCalloutPage.AddServiceCallout(driver);
		
		Thread.sleep(3000);
		
	    JsonToXmlNodePage jsonToXmlNodePage=new JsonToXmlNodePage(driver);
	    jsonToXmlNodePage.AddJsonToXmlNode(driver, "JsonToXmlConverter", "JsonToXmlConverter", envKey, targetvar);
	 
	    String responseString = "{\"Response\" : \"{{{" + targetvar + "}}}\"}";
	    
	    ResponseNodePages responseNodePages=new ResponseNodePages(driver);
	    responseNodePages.AddResponseNode(driver, responseString);
	    
	    deployPage deployPage=new deployPage(driver);
	    deployPage.StageDeployTheWorkflow(driver);
	    Thread.sleep(2000);
	    
	    RunPage runPage=new RunPage(driver);
	    runPage.SatgeRunWorkflow(driver);
	    
	    Thread.sleep(3000);
	    
//	    jsonToXmlNodePage.validatingTheXMLDataAfterConvertingFronJsonToXML(driver);
	    
	        
	}

}
