package com.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.testcases.BaseClass;



public class ListenerClass extends BaseClass implements ITestListener {


  	public ExtentTest logger;
	
  	ExtentReports extent=ExtendReporting.reportGeneration();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		logger=extent.createTest(result.getMethod().getMethodName());
	}
		
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		//logger=extent.createTest(result.getName());// create new entry in th report
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS,"test case passed is  "   +result.getName());
			logger.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
		}
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	//	logger=extent.createTest(result.getName());// create new entry in th report
		
		WebDriver driver=null;
		
			
			try {
				driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(result.getStatus()==ITestResult.FAILURE)
			{
			logger.log(Status.FAIL,"test case failed is   "    +result.getName());
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
			logger.log(Status.FAIL,"test case failed is" +result.getThrowable());
			
				try {
					String screenpath=ListenerClass.takeScreenshot(driver, result.getName());
					logger.addScreenCaptureFromPath(screenpath);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
							
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	
		//logger=extent.createTest(result.getName()); // create new entry in th report
		
		if(result.getStatus()==ITestResult.SKIP)
		{
		logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
		extent.flush();
		
	}
	
	

}


