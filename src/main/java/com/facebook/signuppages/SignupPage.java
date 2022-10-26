package com.facebook.signuppages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.base.Base;



public class SignupPage extends Base {
	
	public WebDriver driver;
	public String CURR_APP="signuppages";
	public SignupPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
//By Signin=By.xpath("//section[@id='block-block-3']/div/div/div[3]/div[3]/a");
//By emailid=By.xpath("//input[@id='login_id']");
	
	
	//@FindBy(xpath="//section[@id='block-block-3']/div/div/div[3]/div[3]/a")
	//WebElement Signin;
	
	//@FindBy(xpath="//input[@id='login_id']")
	//WebElement emailid;
	
	
	public void clickSignin(String uname)
	{
		////Signin.click();
		//emailid.sendKeys(uname);
		//entertext("emailid","rshanthi2285@gmail.com");
		click("xpath","Signin",CURR_APP);
		entertext("xpath","entervalue",CURR_APP,uname);
	}
	
	
	
	
}
