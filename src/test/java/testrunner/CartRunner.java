package testrunner;
import org.junit.runner.RunWith;

import cucumber.junit.Cucumber; 

@RunWith(Cucumber.class) 
@Cucumber.Options(format = {"pretty", "html:target/cucumber-htmlreport"}, glue= {"stepsDefinition"})
public class CartRunner {

}
