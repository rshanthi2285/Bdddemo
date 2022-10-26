package com.facebook.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import com.facebook.base.Base;
import com.facebook.listeners.CustomListeners;
import com.google.common.io.Files;

@Listeners(CustomListeners.class)

public class Utils extends Base{
	
	
public static String screenshotname;
	
public static String CaptureScreenShot(WebDriver driver, String screenshotname) throws IOException
{
	String dateName=new SimpleDateFormat("YYYY_MM_DD_HH_MM").format(new Date());
TakesScreenshot ts=((TakesScreenshot)driver);
File Source=ts.getScreenshotAs(OutputType.FILE);
String dest=".\\test-output\\"+screenshotname+dateName+".jpg";
File destination=new File(dest);
FileUtils.copyFile(Source, destination);
return dest;
}

}
