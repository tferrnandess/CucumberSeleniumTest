package stepsDefinition;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Given; 
import cucumber.annotation.en.Then; 
import cucumber.annotation.en.When;
import cucumber.api.PendingException; 

public class StepsSignIn{ 
   WebDriver driver = null; 
	
   @Given("^I stay at SignIn page$") 
   public void SignInPage() { 
	  System.setProperty("webdriver.gecko.driver", "src/main/java/support/geckodriver.exe");
      driver = new FirefoxDriver(); 
      driver.get("http://automationpractice.com/index.php"); 
      driver.manage().window().maximize();
      driver.findElement(By.className("login")).click();
   } 
	
   @When("^I input the email address$") 
   public void EmailAddress() { 
	   driver.findElement(By.id("email_create")).sendKeys("testthiago@gmail.com");
   } 
	
   @Then("^I can create an account$") 
   public void SubmitEmail() throws Exception { 
      
          driver.findElement(By.id("SubmitCreate")).click();
          driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
          driver.quit();
	   
   }
}