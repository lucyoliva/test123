package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {
WebDriver driver;
public ContactPage(WebDriver driver)
{
	this .driver=driver;
	}

By submitbtn=By.linkText("Submit");
By ErrorName=By.id("forename-err");
By ErrorEmail=By.id("email-err");
By ErrorMessage=By.id("message-err");
By Email=By.id("email");
By forename=By.id("forename");
By message=By.id("message");
By successMessage=By.cssSelector("strong[class='ng-binding']");

public WebElement Submit()
{
	return driver.findElement(submitbtn);
}

public WebElement ErrorName()
{
	return driver.findElement(ErrorName);
}
public WebElement ErrorEmail()
{
	return driver.findElement(ErrorEmail);
}
public WebElement ErrorMessage()
{
	return driver.findElement(ErrorMessage);
}
public WebElement Email()
{
	return driver.findElement(Email);
}
public WebElement forename()
{
	return driver.findElement(forename);
}
public WebElement message()
{
	return driver.findElement(message);
}
public WebElement successMessage()
{
	return driver.findElement(successMessage);
}

}
