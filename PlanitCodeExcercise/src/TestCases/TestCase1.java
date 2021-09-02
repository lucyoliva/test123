package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.ContactPage;
import ObjectRepository.PlanitHomePage;

public class TestCase1 {
	@Test
	public void ValidationErrors()
	{
		WebDriver driver;
System.setProperty("webdriver.chrome.driver","latestChromeDriver//chromedriver_win32 (1)//chromedriver.exe");
 driver=new ChromeDriver();
 
driver.get("https://jupiter.cloud.planittesting.com/#//");
driver.manage().window().maximize();
PlanitHomePage home=new PlanitHomePage(driver);
home.contact().click();
driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
ContactPage contact=new ContactPage(driver);
contact.Submit().click();
Assert.assertEquals(contact.ErrorName().getText(), "Forename is required");
Assert.assertEquals(contact.ErrorEmail().getText(), "Email is required");
Assert.assertEquals(contact.ErrorMessage().getText(), "Message is required");
contact.forename().sendKeys("Jack");
//Verifying Validation errors are gone
Boolean isPresent = driver.findElements(By.id("forename-err")).size() > 0;
Assert.assertFalse(isPresent);
contact.Email().sendKeys("test@gmail.com");
isPresent = driver.findElements(By.id("email-err")).size() > 0;
Assert.assertFalse(isPresent);
contact.message().sendKeys("Message");
isPresent = driver.findElements(By.id("message-err")).size() > 0;
Assert.assertFalse(isPresent);



driver.quit();

		
	}

	

}
