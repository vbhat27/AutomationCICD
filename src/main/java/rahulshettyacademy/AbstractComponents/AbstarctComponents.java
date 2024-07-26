package rahulshettyacademy.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrdersPage;

public class AbstarctComponents {

	WebDriver driver;
	public AbstarctComponents(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartbuttonclick;
	
	@FindBy (css="[class*=flyInOut]")
	WebElement loginerror;
	
	@FindBy (css="[routerlink*='myorders']")
	WebElement ordersbutton;
	
	By cartbuttonvisibbility = By.cssSelector(".totalRow button");
	
	public void visibilityOfElement(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4000));
		driver.findElement(findBy);
		
	}
	
	public void waitforElementtoappear(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	
	public void mouseevents(WebElement mousedriver) {
		
		Actions act = new Actions(driver);
		
		act.moveToElement(mousedriver).click().build().perform();
		
		
	}
	public void dscrollevent()
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
	}
	
	public CartPage cartbuttonclick() throws InterruptedException {
		
		Thread.sleep(1000);
		cartbuttonclick.click();
		CartPage cart = new CartPage(driver);
		return cart;
	}
	public OrdersPage ordersbuttonclick() {
		
		
		ordersbutton.click();
		OrdersPage order = new OrdersPage(driver);
		return order;
	}
	
}
