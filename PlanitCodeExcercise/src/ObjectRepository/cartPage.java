package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class cartPage {
WebDriver driver;
public cartPage(WebDriver driver)
{
	this .driver=driver;
	}

By fluffyBunny=By.xpath("//*[@id=\"product-4\"]/div/p/a");
By stuffedFrog=By.xpath("//*[@id=\"product-2\"]/div/p/a");
By funnycow=By.xpath("//*[@id=\"product-6\"]/div/p/a");
By valentineBear=By.xpath("//*[@id=\"product-7\"]/div/p/a");

By parent=By.cssSelector("tr[ng-repeat*=cart]");
By child1=By.cssSelector("td[class='ng-binding']");
By totalSum=By.cssSelector("strong[class*='total']");



public List<WebElement> parent()
{
	return driver.findElements(parent);
}
public List<WebElement> childs()
{
	return driver.findElements(child1);
}
public WebElement child()
{
	return driver.findElement(child1);
	}
public WebElement totalSum()
{
	return driver.findElement(totalSum);
	}


}
