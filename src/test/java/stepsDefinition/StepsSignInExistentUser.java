package stepsDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class StepsSignInExistentUser {
	WebDriver driver = null; 
	
	   @Given("^I am accessing SignIn page$") 
	   public void SignInPage() { 
		  System.setProperty("webdriver.gecko.driver", "src/main/java/support/geckodriver.exe");
	      driver = new FirefoxDriver(); 
	      driver.get("http://automationpractice.com/index.php"); 
	      driver.manage().window().maximize();
	      driver.findElement(By.className("login")).click();
	   } 
		
	   @When("^I input my email address$") 
	   public void EmailAddress() { 
		   driver.findElement(By.id("email")).sendKeys("sidiagingatest@gmail.com");
		   driver.findElement(By.id("passwd")).sendKeys("teste1234");
	   } 
		
	   @Then("^I am log in an account$") 
	   public void SubmitEmail() throws Exception { 
	      
	          driver.findElement(By.id("SubmitLogin")).click();	
	          driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	          driver.quit();
		   
	   }
}
