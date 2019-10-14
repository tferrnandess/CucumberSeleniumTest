package stepsDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class StepsCart {
	WebDriver driver = null; 
	
	   @Given("^I stay in website$") 
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
		
	   @When("^I added a product to cart$") 
	   public void AddtoCart() { 
		   driver.findElement(By.linkText("Home")).click();
		   driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		   driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();	
	       driver.findElement(By.id("add_to_cart")).click();
	       driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
	       //scroll frame
	       Actions action = new Actions(driver);
	       
	       WebElement element = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a"));
	       action.moveToElement(element).perform();
	       driver.findElement(By.partialLinkText("Proceed")).click();
	       
	   } 
		
	   @Then("^I am check out product$") 
	   public void CheckOutProduct() {
		      driver.findElement(By.partialLinkText("View")).sendKeys("");	
	          driver.findElement(By.id("button_order_cart")).click();
	          driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	          driver.quit();
	          
		   
	   }
}
