package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstarctComponents;

public class PaymentMethod extends AbstarctComponents{

	WebDriver driver;
	
	public PaymentMethod(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement countryname;
	
	@FindBy(css=".totalRow button")
	WebElement selectcounty;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement selectedcountry;
	
	By countrywait = By.cssSelector(".ta-results");
	String inputcountry;
	
	@FindBy(xpath= "(//button[contains(@class,'ta-item')]) [2]")
	WebElement clickonselectedcountry;
	
	@FindBy(css=".action__submit")
	WebElement submitbutton;
	
	By country = By.cssSelector(".totalRow button");
	
	
	public OrderDetailsPage countrySelection(String inputcountry)
	{
//		countryname.sendKeys(inputcountry);
//		visibilityOfElement(country);
//		selectcounty.click();
		Actions act = new Actions(driver);
		act.sendKeys(selectedcountry, inputcountry).build().perform();
		visibilityOfElement(countrywait);
		clickonselectedcountry.click();
		dscrollevent();
		mouseevents(submitbutton);
		OrderDetailsPage order = new OrderDetailsPage(driver);
		return order;
		
	}

}
