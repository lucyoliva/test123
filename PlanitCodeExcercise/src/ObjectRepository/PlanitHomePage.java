package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlanitHomePage {
WebDriver driver;
public PlanitHomePage(WebDriver driver)
{
	this .driver=driver;
	}

By contact=By.linkText("Contact");
By shop=By.linkText("Shop");
By cart=By.xpath("//*[@id=\'nav-cart\']/a");

public WebElement contact()
{
	return driver.findElement(contact);
	}
public WebElement cart()
{
	return driver.findElement(cart);
	}
public WebElement shop()
{
	return driver.findElement(shop);
	}


}
