package stepsDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class StepsQuickViewWishlist {
	WebDriver driver = null; 
	
	   @Given("^I was logged with valid user$") 
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
		
	   @When("^I was accessed product quickview$") 
	   public void AccessQuickView() { 
		   driver.findElement(By.linkText("Home")).click();
		   driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	   } 
		
	   @Then("^I can add product as wishlist$") 
	   public void AddToWishlist() { 
	      
	          driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();	
	          driver.findElement(By.id("wishlist_button")).click();
	          driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	          driver.quit();
	          
		   
	   }
}
