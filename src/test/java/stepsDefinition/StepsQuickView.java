package stepsDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.openqa.selenium.By; 

public class StepsQuickView {
	WebDriver driver = null; 
	
	   @Given("^I am logged with valid user$") 
	   public void LogInPage() { 
		  System.setProperty("webdriver.gecko.driver", "src/main/java/support/geckodriver.exe");
	      driver = new FirefoxDriver(); 
	      driver.get("http://automationpractice.com/index.php"); 
	      driver.manage().window().maximize();
	      driver.findElement(By.className("login")).click();
	      driver.findElement(By.id("email")).sendKeys("sidiagingatest@gmail.com");
		  driver.findElement(By.id("passwd")).sendKeys("teste1234");
		  driver.findElement(By.id("SubmitLogin")).click();	
		  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	   } 
		
	   @When("^I access product quickview$") 
	   public void AccessQuickView() { 
		   driver.findElement(By.linkText("Home")).click();
		   driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	   } 
		
	   @Then("^I can add to cart$") 
	   public void AddToCart() throws Exception { 
	      
	          driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();	
	          driver.findElement(By.id("add_to_cart")).click();
	          driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	          driver.quit();
	          
		   
	   }
}
