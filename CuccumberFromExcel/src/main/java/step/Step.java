package step;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ExcelReader.ExcelReader;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Step {
	
	WebDriver driver;
	String sentence=null;
	String word=null;
	String chromedriver="chromedriver.exe";
	
	
	
	@Given("^user is already on WSD page$")
	public void user_already_on_page(){
		ClassLoader classLoader = getClass().getClassLoader();
		
		System.setProperty("webdriver.chrome.driver", classLoader.getResource(chromedriver).getFile());
		
 		driver=new ChromeDriver();
 		driver.get("http://vishakh.pythonanywhere.com/");
 	}
	@Then("^user enters \\\"([^\\\"]*)\\\"$")
	public void user_enters_and(String dataid)  {
		int row = Integer.parseInt(dataid);
		ExcelReader excelreader=new ExcelReader();
		excelreader.readSheet(row);
		/*
		 * System.out.println(sentence); System.out.println(word);
		 */
		driver.findElement(By.xpath("/html/body/form/div/div/div/p/table/tbody/tr[1]/td[4]/input")).clear();
		driver.findElement(By.xpath("/html/body/form/div/div/div/p/table/tbody/tr[1]/td[4]/input")).sendKeys(excelreader.sentence);
		driver.findElement(By.xpath("/html/body/form/div/div/div/p/table/tbody/tr[2]/td[4]/input")).clear();
		driver.findElement(By.xpath("/html/body/form/div/div/div/p/table/tbody/tr[2]/td[4]/input")).sendKeys(excelreader.word);
		
		}
	@And("^enters submit button$")
	public void submit() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/form/div/div/div/p/table/tbody/tr[3]/td[4]/input")).click();
		Thread.sleep(2500);
		driver.close();
	}
}
