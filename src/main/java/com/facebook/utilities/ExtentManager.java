package com.facebook.utilities;

import java.io.File;


import com.facebook.base.Base;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager extends Base {
	
	//private static ExtentReports extent;

	public static ExtentReports getInstance() {
		
		extent=new ExtentReports(".\\test-output\\html\\extent.html",true,DisplayOrder.NEWEST_FIRST);
		
		extent.loadConfig(new File("C:\\Users\\radkr\\eclipse-workspace\\BDD\\src\\test\\resources\\extentConfig\\Reportsconfig.xml"));
		
		return extent;
		
	}
}
