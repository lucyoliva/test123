package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.ContactPage;
import ObjectRepository.PlanitHomePage;
import ObjectRepository.ShopPage;
import ObjectRepository.cartPage;

public class TestCase3 {
	@Test
	public void ValidateItemInCart()
	{
		WebDriver driver;
System.setProperty("webdriver.chrome.driver","latestChromeDriver//chromedriver_win32 (1)//chromedriver.exe");
 driver=new ChromeDriver();

driver.get("https://jupiter.cloud.planittesting.com/#//");
driver.manage().window().maximize();
PlanitHomePage home=new PlanitHomePage(driver);
ShopPage shop=new ShopPage(driver);
cartPage cart=new cartPage(driver);
//home.contact().click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
home.shop().click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
WebElement element=driver.findElement(By.xpath("//*[@id=\"product-6\"]/div/p/a"));
//WebElement element=driver.findElement(By.linkText("Buy"));

System.out.println(element.getText());
JavascriptExecutor executor = (JavascriptExecutor)driver;
//executor.executeScript("arguments[0].click();", element);
executor.executeScript("arguments[0].scrollIntoView(true);", element);
for (int i=0;i<2;i++)
shop.funnycow().click();
shop.fluffyBunny().click();
home.cart().click();

String Item1=cart.parent().get(0).findElement(By.cssSelector("td[class='ng-binding']")).getText();
Assert.assertEquals(Item1, "Funny Cow");
String Item2=cart.parent().get(1).findElement(By.cssSelector("td[class='ng-binding']")).getText(); 

Assert.assertEquals(Item2, "Fluffy Bunny");

 driver.quit();
	
	}

	

}
