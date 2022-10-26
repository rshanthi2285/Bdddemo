package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.facebook.base.Base;
import com.facebook.defaultpages.DefaultPage;
import com.facebook.listeners.CustomListeners;
import com.facebook.signuppages.SignupPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(CustomListeners.class)
public class steps extends Base {
	//WebDriver driver;
	DefaultPage d1;
	
	@Given("User is on the default page")
	public void user_is_on_the_default_page() {
		exec();
		navigatetourl();
		System.out.println("user on home page");
	}

	@Then("User clicks on signup now")
	public void User_clicks_on_signup_now() throws InterruptedException {
		d1=new DefaultPage(driver);
		d1.clickoncrmDefaultPage();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//span[@class='zwf_close_icn']")).click();
	}
	
	@Then("User navigates back and click on mail")
	public void user_navigates_back_and_click_on_mail() throws InterruptedException {
	   d1.crmemail();
	   Thread.sleep(5000);
	}


	
	@Then("User clicks on sigin")
	public void user_clicks_on_sigin() {
	    SignupPage s1=new SignupPage(driver);
	    s1.clickSignin("shanthi.suba@gmail.com");
	   // Assert.fail();
	}




}
