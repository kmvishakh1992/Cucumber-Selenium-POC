package step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Step {
	
	WebDriver driver;
	
	@Given("^user is already on Login Page$")
	public void user_already_on_page(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/vishakh/Downloads/Compressed/chromedriver.exe");
		
 		driver=new ChromeDriver();
 		driver.get("http://vishakh.pythonanywhere.com/");
 	}
	@Then("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String name, String password)  {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(name);
		System.out.println(password);
		driver.findElement(By.xpath("/html/body/form/div/div/div/p/table/tbody/tr[1]/td[4]/input")).clear();
		driver.findElement(By.xpath("/html/body/form/div/div/div/p/table/tbody/tr[1]/td[4]/input")).sendKeys(name);
		driver.findElement(By.xpath("/html/body/form/div/div/div/p/table/tbody/tr[2]/td[4]/input")).clear();
		driver.findElement(By.xpath("/html/body/form/div/div/div/p/table/tbody/tr[2]/td[4]/input")).sendKeys(password);
		driver.close();
		}
}
