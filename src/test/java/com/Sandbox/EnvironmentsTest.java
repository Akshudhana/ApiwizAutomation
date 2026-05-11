package com.Sandbox;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import com.GenericUtility.BaseClass;
import com.PomPages.LoginPage;
import com.SandboxPomPage.EnvironmentPage;
import com.SandboxPomPage.NavigatingToSandoxPage;
import com.mysql.cj.util.LogUtils;



@Listeners(com.GenericUtility.ListImpClassA.class)

public class EnvironmentsTest extends BaseClass
{
	@Test
	public void CreateEnvironment() throws InterruptedException {
	
	LoginPage loginPage = new LoginPage(driver);
    loginPage.AkshathadevStageLogin();
//    loginPage.AcmeteamProductionLogin();
	
	NavigatingToSandoxPage navigatingToSandox=new NavigatingToSandoxPage(driver);
	navigatingToSandox.navigatingToSandbox(driver);
	
     EnvironmentPage environmentPage=new EnvironmentPage(driver);
     
     String envName = "Env";
     environmentPage.CreateEnvironment(driver, envName, "envdescription", "payload", "{\"User\" : \"admin\"}");
     
	}
	
}
