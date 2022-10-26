package stepdefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features=".\\src\\test\\resources\\features",glue= {"stepdefinitions"},monochrome=true,
		plugin= {"pretty","html:target/HtmlReports","pretty","json:target/reports"},
		tags="@smoketest"
		
		)
public class Runner extends AbstractTestNGCucumberTests {

}
