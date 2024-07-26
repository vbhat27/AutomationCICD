package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstarctComponents;

public class OrdersPage extends AbstarctComponents{

	WebDriver driver;
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (css="//tr/td[2]")
	List<WebElement> productdetails;

	public boolean listOfProducts(String listofprods)
	{
		 boolean check = productdetails.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(listofprods));
		 return check;
		
	}
	
	
	
}
