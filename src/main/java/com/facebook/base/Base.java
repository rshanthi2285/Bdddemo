package com.facebook.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


import com.facebook.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties locators=new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");
    public static ExtentReports extent=ExtentManager.getInstance();
    public static ExtentTest test;
    
    public String CURR_APP;
   
	@BeforeSuite
	public void exec()  {
		
		if(driver==null) {
		
		try {
			fis=new FileInputStream(".\\src\\test\\resources\\properties\\configs.properties");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			config.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
		if(config.getProperty("browser").equalsIgnoreCase("chrome"))
				{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
				}
		else if(config.getProperty("browser").equalsIgnoreCase("firefox"))
			
		{
			driver=WebDriverManager.firefoxdriver().create();
			//System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\drivers\\geckodriver.exe");
			//driver=new FirefoxDriver();
		}
		else if(config.getProperty("browser").equalsIgnoreCase("edge"))
		{

			System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\drivers\\edge.exe");
			driver=new FirefoxDriver();
		}
//	driver.get(config.getProperty("appURL"));
//		log.debug("successfully opened URL");
//		driver.manage().window().maximize();

	
}
	
	public void navigatetourl() {
		
		driver.get(config.getProperty("appURL"));
		log.debug("successfully opened URL");
		driver.manage().window().maximize();
	}

	
	public boolean verifyelementpresent(String element)
	{
		try {
			
		if(locators.getProperty(element).contains("xpath"))
		{
			driver.findElement(By.xpath(locators.getProperty(element)));
		}
			 
			
		else if((locators.getProperty(element).contains("css"))) {		
				driver.findElement(By.cssSelector(locators.getProperty(element)));
				
			 
		}
		else if(locators.getProperty(element).contains("id")) {
			driver.findElement(By.id(locators.getProperty(element)));
			
		}
			return true;
		
		
	}catch(NoSuchElementException e)
		{
		return false;
		}
	}
	
	
	public void entertext(String locator,String value,String CURR_APP,String text)
	{
		this.CURR_APP=CURR_APP;
		try {
			fis=new FileInputStream(".\\src\\main\\java\\com\\facebook\\"+this.CURR_APP+"\\elementidentifier.properties");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			locators.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		if(locator.contains("xpath"))
		{
			driver.findElement(By.xpath(locators.getProperty(value))).sendKeys(text);
			
		}
		else if(locator.contains("css"))
		{
			driver.findElement(By.cssSelector(locators.getProperty(locator))).sendKeys(text);
		}
	}
	
	public void click(String locator,String value,String CURR_APP)
	{
		
		this.CURR_APP=CURR_APP;
		try {
			fis=new FileInputStream(".\\src\\main\\java\\com\\facebook\\"+this.CURR_APP+"\\elementidentifier.properties");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			locators.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		if(locator.contains("xpath"))
		{
			driver.findElement(By.xpath(locators.getProperty(value))).click();
		}
		else if(locator.contains("locator.css"))
		{
			driver.findElement(By.cssSelector(locators.getProperty(value))).click();
		}
		//test.log(LogStatus.INFO,"Clicking on" +locator);
	}
	
	public String printtext(String locator)
	{
		String text=null;
//		if(locator.endsWith("xpath"))
//		{
			text=driver.findElement(By.xpath(locators.getProperty(locator))).getText();
//		}
//		else if(locator.endsWith("css"))
//		{
//			text=driver.findElement(By.cssSelector(locators.getProperty(locator))).getText();
//		}
		return text;
	}
	

	
	@AfterSuite
	public void teardown()
	{
		if(driver!=null) {
		driver.quit();
		
	}

}
}
