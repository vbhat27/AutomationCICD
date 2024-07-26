package rahulshettyacademy.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstarctComponents;


public class OrderDetailsPage extends AbstarctComponents{

	WebDriver driver;
	
	
	public OrderDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".hero-primary")
	WebElement confirmmsgdisplay;
	
	public String orderDetailsPage()
	{
		return confirmmsgdisplay.getText();	
		
		
		
	}
	
}
