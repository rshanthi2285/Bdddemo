package com.facebook.listeners;

import java.io.IOException;

import javax.swing.text.Utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.facebook.base.Base;
import com.facebook.utilities.Utils;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListeners extends Base implements ITestListener {
	
	public void onTestStart(ITestResult result)
	{
		test=extent.startTest(result.getName().toUpperCase());
		test.log(LogStatus.INFO, "Test Started");
		
	}
	
	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output","false");

	test.log(LogStatus.FAIL, result.getName().toUpperCase()+"Failed with exception"+result.getThrowable());
		//test.log(LogStatus.FAIL,test.addScreenCapture(Utils.screenshotname) );
		try {
		String screenshotpath=Utils.CaptureScreenShot(driver,result.getName());
		test.log(LogStatus.FAIL, test.addScreenCapture(screenshotpath));
	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
////		test.log(LogStatus.FAIL, test.addScreenCapture(".\\test-output\\screenshot"));
//		test.log(LogStatus.FAIL,"Failed Test is:"+result.getName());
//		test.log(LogStatus.FAIL, "Failed Test is"+result.getThrowable());
//		String screenshotpath=
			
	
//		Reporter.log("Click on the image to view the screenshot");
//		//Reporter.log("<a target=\"_blank\" href="+Utils.screenshotname);
//		Reporter.log("<br>");
//		Reporter.log("<a target=\"_blank\" href=\"+Utils.screenshotname+\"><img src=\"+Utils.screenshotname+\" "
//				+ "height=300 width=300></img></a>");
		extent.endTest(test);
		extent.flush();
		}
	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.startTest(result.getName().toUpperCase());
		test.log(LogStatus.PASS, "Pass");
		test.log(LogStatus.INFO, "Test Passed");
		extent.endTest(test);
		extent.flush();
	}

}
