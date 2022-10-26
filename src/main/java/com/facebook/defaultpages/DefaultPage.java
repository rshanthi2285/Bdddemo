package com.facebook.defaultpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.facebook.base.Base;



public class DefaultPage extends Base  {
	
	public WebDriver driver;
	public String CURR_APP="defaultpages";
	
	public DefaultPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//By Crmsignup=By.xpath("//span[@class='promo-appicon promo-crm']");
	//By Crmemail=By.xpath("//li[@class='zp-main-apps zp-main-mail zapp-show']");
	public void clickoncrmDefaultPage()
	{
		//click("Crmsignupxpath");
		//driver.findElement(Crmsignup).click();
		click("xpath","Crmsignupxpath",CURR_APP);
	}
	
	public void crmemail()
	{
		//driver.findElement(Crmemail).click();
		click("xpath","Crmemail",CURR_APP);
}

}
