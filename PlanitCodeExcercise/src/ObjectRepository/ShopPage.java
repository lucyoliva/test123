package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage {
WebDriver driver;
public ShopPage(WebDriver driver)
{
	this .driver=driver;
	}

By fluffyBunny=By.xpath("//*[@id=\"product-4\"]/div/p/a");
By stuffedFrog=By.xpath("//*[@id=\"product-2\"]/div/p/a");
By funnycow=By.xpath("//*[@id=\"product-6\"]/div/p/a");
By valentineBear=By.xpath("//*[@id=\"product-7\"]/div/p/a");



public WebElement fluffyBunny()
{
	return driver.findElement(fluffyBunny);
}

public WebElement stuffedFrog()
{
	return driver.findElement(stuffedFrog);
}
public WebElement funnycow()
{
	return driver.findElement(funnycow);
}
public WebElement valentineBear()
{
	return driver.findElement(valentineBear);
}

}
