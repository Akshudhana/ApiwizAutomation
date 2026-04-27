package com.GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListImpClassA implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	
	//WebDriver driver;
	
	@Override
	public void onTestStart(ITestResult result) {
	//Execution starts from here
		String methodName=	result.getMethod().getMethodName();
		test=report.createTest(methodName);
		
		Reporter.log(methodName+"---> Execution starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=	result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"-->Passes");
		Reporter.log(methodName+"-->TestScript executed succesfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	    System.out.println("--- onTestFailure Triggered for: " + result.getName() + " ---");
	    
	    WebDriverUtils webDriverUtilsobject = new WebDriverUtils();
	    try {
	        String methodName = result.getMethod().getMethodName();
	        
	        // PRINT THIS: Check if driver is null
	        System.out.println("Driver Instance: " + BaseClass.driver); 
	        
	        String screenShotPath = webDriverUtilsobject.takescreenshot(BaseClass.driver, methodName);
	        
	        // PRINT THIS: Check if the path is actually created
	        System.out.println("Screenshot saved at: " + screenShotPath);
	        
	        test.log(Status.FAIL, methodName + " failed");
	        test.addScreenCaptureFromPath(screenShotPath);
	        
	    } catch (Exception e) {
	        System.out.println("EXCEPTION IN LISTENER: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
//	public void onTestFailure(ITestResult result) {
//	    WebDriverUtils webDriverUtilsobject = new WebDriverUtils();
//	    
//	    // 1. Get the actual driver instance from the test class that failed
//	    WebDriver failureDriver = null;
//	    try {
//	        // This looks into the actual class running the test to find the driver
//	        failureDriver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//	    } catch (Exception e) {
//	        // Fallback to BaseClass.driver if the above fails
//	        failureDriver = BaseClass.driver;
//	    }
//
//	    try {
//	        String methodName = result.getMethod().getMethodName();
//	        
//	        // 2. Pass the failureDriver instead of BaseClass.driver
//	        String screenShotPath = webDriverUtilsobject.takescreenshot(failureDriver, methodName);
//	        
//	        // 3. Ensure 'test' is initialized before this line
//	        if (test != null) {
//	            test.log(Status.FAIL, methodName + "------>Failed");
//	            test.log(Status.FAIL, result.getThrowable());
//	            test.addScreenCaptureFromPath(screenShotPath);
//	        }
//	        
//	        Reporter.log(methodName + "--->Failed");
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
//	}

	//@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"--->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+"-->Skipped");
			}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		WebDriverUtils webDriverUtils=new WebDriverUtils();

		
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".//ExtentReport//report"+webDriverUtils.getSystemDateInFormat()+".html");
		//It will create one emptyPage
		htmlReport.config().setDocumentTitle("APIWIZ");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("Akshatha");
		
		//ExtentReports report=new ExtentReports();
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		
		report.setSystemInfo("Base platform", "Windows 11");
	report.setSystemInfo("Base Browser", "chrome");
	report.setSystemInfo("Base URL", "https://acme-team-production.apiwiz.io/auth");
	report.setSystemInfo("Reporter name", "Akshatha");	
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	} 
	

}
