package com.lambdatest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Scenario2 {

	WebDriver driver = null;
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	}
	@Test
	public void assignment2() {

		driver.get("https://www.testmuai.com/selenium-playground/");
		driver.findElement(By.xpath("//a[.='Drag & Drop Sliders']")).click();
		WebElement slider = driver.findElement(By.xpath("//h4[.=' Default value 15']/following::input[1]"));
		Actions act = new Actions(driver);
		//act.clickAndHold(slider).moveByOffset(120, 0).pause(Duration.ofMillis(300)).release().perform();
		int width = slider.getSize().getWidth();
		int percentage = (width*44)/100;
		act.dragAndDropBy(slider,percentage, 0).perform();
		//act.moveToElement(slider, percentage, 0).click().perform();
		WebElement rangeText = driver.findElement(By.id("rangeSuccess"));
		String rangeVal = rangeText.getText();
		System.out.print(rangeVal);
		int expectedRange = 95;
		if(Integer.parseInt(rangeVal)== expectedRange)
		{
			System.out.print("Value match");
		}else {
			System.out.print("Value does not match");
			
		}
				
			
		
	}

	@AfterMethod
	public void teardown() {
	    driver.quit();
	}
}
