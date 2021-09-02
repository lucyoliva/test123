package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
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

public class TestCase4 {
	@Test
	public void ValidatePrices()
	{
		WebDriver driver;
System.setProperty("webdriver.chrome.driver","latestChromeDriver//chromedriver_win32 (1)//chromedriver.exe");
 driver=new ChromeDriver();

driver.get("https://jupiter.cloud.planittesting.com/#//");
driver.manage().window().maximize();
PlanitHomePage home=new PlanitHomePage(driver);
ShopPage shop=new ShopPage(driver);
cartPage cart=new cartPage(driver);

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
home.shop().click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
WebElement element=driver.findElement(By.xpath("//*[@id=\"product-2\"]/div/p/a"));
//WebElement element=driver.findElement(By.linkText("Buy"));

System.out.println(element.getText());
JavascriptExecutor executor = (JavascriptExecutor)driver;
//executor.executeScript("arguments[0].click();", element);
executor.executeScript("arguments[0].scrollIntoView(true);", element);

for (int i=0;i<2;i++)
	shop.stuffedFrog().click();

for (int i=0;i<5;i++)
shop.fluffyBunny().click();
for (int i=0;i<3;i++)
shop.valentineBear().click();
home.cart().click();

//Validate price for each product
String ItemPrice1=cart.parent().get(0).findElements(By.cssSelector("td[class='ng-binding']")).get(1).getText();
Assert.assertEquals(ItemPrice1,"$10.99");
String ItemPrice2=cart.parent().get(1).findElements(By.cssSelector("td[class='ng-binding']")).get(1).getText();
Assert.assertEquals(ItemPrice2,"$9.99");
String ItemPrice3=cart.parent().get(2).findElements(By.cssSelector("td[class='ng-binding']")).get(1).getText();
Assert.assertEquals(ItemPrice3,"$14.99");

//Validate price for each product sub total
//verify subtotal also returns expected subtotal
 
Double expectedTotal=0.0;
expectedTotal=expectedTotal+verifysubtotal(driver,1,2);
expectedTotal=expectedTotal+verifysubtotal(driver,2,5);
expectedTotal=expectedTotal+verifysubtotal(driver,3,3);
System.out.println(expectedTotal);

String actualtotalsum=cart.totalSum().getText();
actualtotalsum=actualtotalsum.substring(7);
System.out.print("actual="+actualtotalsum);
Double actual=Double.parseDouble(actualtotalsum);
Assert.assertEquals(expectedTotal,actual);


 driver.quit();
	
	}
	public double price(String priceText)
	{
		String Text=priceText.substring(1);
		Double i=Double.parseDouble(Text);
		return i; 
	}
	public double subtotal(String PriceText,int count)
	{
		return (price(PriceText)*count);
	}
	
	//Validate price for each product sub total
	public double verifysubtotal(WebDriver driver,int itemorder,int count)
	{
		itemorder--;
		String ItemPrice=driver.findElements(By.cssSelector("tr[ng-repeat*=cart]")).get(itemorder).findElements(By.cssSelector("td[class='ng-binding']")).get(1).getText();
		Double subTotal=price(driver.findElements(By.cssSelector("tr[ng-repeat*=cart]")).get(itemorder).findElements(By.cssSelector("td[class='ng-binding']")).get(2).getText());
		Double ExpectedsubTotal=subtotal(ItemPrice,count);
		Assert.assertEquals(subTotal, ExpectedsubTotal);
		System.out.println("Actual subtotal of "+subTotal);
		System.out.println("Expected subtotal of "+ExpectedsubTotal);
		return ExpectedsubTotal;
	}

	

}