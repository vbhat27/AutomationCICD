package rahulshettyacademy.pageobjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstarctComponents;


public class CartPage extends AbstarctComponents{

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> cartitems;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutbutton;
	
	By countrywait = By.cssSelector(".ta-results");
	String inputcountry;
	
	By checkoutbuttonwait = By.cssSelector(".totalRow button");
	
	public boolean cartdetails(String listofprods)
	{
		
		boolean check = cartitems.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(listofprods));
		 return check;
		 
	}
	public PaymentMethod checkoutbutton() throws InterruptedException
	{
		visibilityOfElement(checkoutbuttonwait);
		//dscrollevent();
		Actions act = new Actions(driver);
		act.moveToElement(checkoutbutton).click().build().perform();
		//checkoutbutton.click();
		PaymentMethod pay = new PaymentMethod(driver);
		return pay;
	}
	
	
	
}
