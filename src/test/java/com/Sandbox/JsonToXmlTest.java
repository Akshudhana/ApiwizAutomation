package com.Sandbox;

import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.PomPages.LoginPage;
import com.SandboxPomPage.AddCollection;
import com.SandboxPomPage.AddServiceCalloutPage;
import com.SandboxPomPage.EnvironmentPage;
import com.SandboxPomPage.JsonToXmlNodePage;
import com.SandboxPomPage.NavigatingToSandoxPage;
import com.SandboxPomPage.ResponseNodePages;

public class JsonToXmlTest extends BaseClass{
	
	@Test
	public void AddJsonToXmlNode() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
//		loginPage.LoginToApp("https://acme-team-production.apiwiz.io/auth","AkshathaSM", "L8#kR!9vPz@4tQ2sAD512");
		loginPage.LoginToApp("https://akshatha-dev.apiwiz.io/", "TeamUserAnkit", "Devuseraccount@8");
		
		NavigatingToSandoxPage navigatingToSandox=new NavigatingToSandoxPage(driver);
		navigatingToSandox.navigatingToSandbox(driver);
		
		String envName = "env";
		String envKey="payload";
		String targetvar = "taegetvar";
		
		EnvironmentPage environmentPage=new EnvironmentPage(driver);
		environmentPage.CreateEnvironment(driver, envName, "Env_desc", envKey, "{\"User\" : \"admin\"}");
		

		AddCollection addCollection = new AddCollection(driver);
		String collectionName = addCollection.generateCollectionName("ApiEnvcollectionasssss");
		
		addCollection.createCollection(driver, collectionName);
		
		addCollection.getCollection(driver, collectionName);
		addCollection.CreateWorkflowByAddingEnvironment(driver, "JsonToXml", "JsonToXml", envName);
		
		AddServiceCalloutPage addServiceCalloutPage=new AddServiceCalloutPage(driver);
		addServiceCalloutPage.AddServiceCallout(driver);
		
	    JsonToXmlNodePage jsonToXmlNodePage=new JsonToXmlNodePage(driver);
	    jsonToXmlNodePage.AddJsonToXmlNode(driver, "jsonNodeName", "JsonDesc", envKey, targetvar);
	 
	    String responseString = "{\"Response\" : \"{{" + envKey + "}}\"}";
	    
	    ResponseNodePages responseNodePages=new ResponseNodePages(driver);
	    responseNodePages.AddResponseNode(driver, targetvar);
	    
	    
	    
		
	}

}
