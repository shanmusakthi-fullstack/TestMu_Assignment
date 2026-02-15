package com.lambdatest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Scenario1_2browser {
	static WebDriver driver = null;
	
	@BeforeMethod
	@Parameters("browsername")
	public void setup(String browsername) {
	    if(browsername.equalsIgnoreCase("chrome")) {
	        driver = new ChromeDriver();
	    } else if(browsername.equalsIgnoreCase("firefox")) {
	        driver = new FirefoxDriver();
	    }
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@Test
		public void assignment1(String browsername) {
		
		driver.get("https://www.testmuai.com/selenium-playground/");
		driver.findElement(By.xpath("//a[.='Simple Form Demo']")).click();
		//String actualTitle =  driver.getTitle();
		//String expectedTitle = "simple-form-demo";
		//Assert.assertEquals(actualTitle,expectedTitle);
		String actualURL =  driver.getCurrentUrl();
		Assert.assertTrue(actualURL.contains("simple-form-demo"));
		//String message = "Welcome to TestMu A";
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		//WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Please enter your Message']")));
	 	//WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'user-message']")));
		//WebElement textBox = driver.findElement(By.xpath("//input[@placeholder='Please enter your Message' and @id = 'user-message' ]"));
		//textBox.sendKeys(message);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('user-message').value = \"Welcome to TestMu A\";" );
		driver.findElement(By.xpath("//button[@id = 'showInput']")).click();
		WebElement textlabel = driver.findElement(By.xpath("//p[@id = 'message']"));
		String Textmsg = textlabel.getText();
		Assert.assertEquals(Textmsg,"Welcome to TestMu A" );
		
		
	}
	@AfterMethod
	public void teardown() {
	    
	        driver.quit();
	    
	}
}
