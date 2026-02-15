package selenium101;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Scenario3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://www.testmuai.com/selenium-playground/");
		driver.findElement(By.xpath("//a[.='Input Form Submit']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Submit']")));
		//button.click();
		//WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		//String message = name.getAttribute("validationMessage");
		//System.out.print(message);
		//Assert.assertTrue(message.contains("Please fill in this field."));
		
		WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		Actions actions = new Actions (driver);
		actions.moveToElement(name).click().sendKeys("Sakthi").build().perform();
		
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		actions.moveToElement(email).click().sendKeys("shanmusakthi@gmail.com").build().perform();
		
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		actions.moveToElement(password).click().sendKeys("1212121").build().perform();
		
		WebElement company = driver.findElement(By.xpath("//input[@placeholder='Company']"));
		actions.moveToElement(company).click().sendKeys("Besant").build().perform();
		
		WebElement website = driver.findElement(By.xpath("//input[@placeholder='Website']"));
		actions.moveToElement(website).click().sendKeys("testmuai.com").build().perform();
		
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		dropdown.selectByVisibleText("India");
		
		WebElement city = driver.findElement(By.xpath("//input[@placeholder='City']"));
		actions.moveToElement(city).click().sendKeys("Bangalore").build().perform();
		
		
		WebElement address1 = driver.findElement(By.xpath("//input[@placeholder='Address 1']"));
		actions.moveToElement(address1).click().sendKeys("Bangalore").build().perform();
		
		
		WebElement address2 = driver.findElement(By.xpath("//input[@placeholder='Address 2']"));
		actions.moveToElement(address2).sendKeys("SouthBangalore").build().perform();
		
		WebElement state = driver.findElement(By.xpath("//input[@placeholder='State']"));
		actions.moveToElement(state).sendKeys("Karnataka").build().perform();
		
		
		WebElement zipcode = driver.findElement(By.xpath("//input[@placeholder='Zip code']"));
		actions.moveToElement(zipcode).sendKeys("560060").build().perform();
		
		WebElement button1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Submit']")));
		button1.click();
		
		WebElement contactMsg = driver.findElement(By.xpath("//p[contains(text( ), 'Thanks')]"));
		String validationMessage = contactMsg.getText();
		Assert.assertEquals(validationMessage, "Thanks for contacting us, we will get back to you shortly.");
		

	}

}
