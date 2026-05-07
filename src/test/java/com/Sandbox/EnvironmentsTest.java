package com.Sandbox;


import org.testng.annotations.Test;
import com.GenericUtility.BaseClass;
import com.PomPages.LoginPage;
import com.SandboxPomPage.EnvironmentPage;
import com.SandboxPomPage.NavigatingToSandoxPage;





public class EnvironmentsTest extends BaseClass
{
	@Test
	public void CreateEnvironment() throws InterruptedException {
	
	LoginPage loginPage = new LoginPage(driver);
//	loginPage.LoginToApp("https://acme-team-production.apiwiz.io/auth","AkshathaSM", "L8#kR!9vPz@4tQ2sAD512");
	loginPage.LoginToApp("https://akshatha-dev.apiwiz.io/", "TeamUserAnkit", "Devuseraccount@8");
	
	NavigatingToSandoxPage navigatingToSandox=new NavigatingToSandoxPage(driver);
	navigatingToSandox.navigatingToSandbox(driver);
	
     EnvironmentPage environmentPage=new EnvironmentPage(driver);
     
     String envName = "Env";
     environmentPage.CreateEnvironment(driver, envName, "envdescription", "payload", "{\"User\" : \"admin\"}");
     
	}
	
	



}
