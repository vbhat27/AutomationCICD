package rahulshettyacademy.pageobjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstarctComponents;


public class ProductCatalogue extends AbstarctComponents{

		WebDriver driver;

		public ProductCatalogue(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);

			
		}
		
		@FindBy(css=".mb-3")
		List<WebElement> products;
		
		@FindBy(css=".ng-tns-c4-2")
		WebElement cartmsg;
		
		@FindBy(css="button[routerlink='/dashboard/cart']")
		WebElement cartbuttonclick;
		
		By productslist = By.cssSelector(".mb-3");
		By cartbutton = By.cssSelector(".card-body button:last-of-type");
		By spinner = By.cssSelector(".ng-tns-c4-2");
	
		
		
		public List<WebElement> listOfProducts()
		{
			visibilityOfElement(productslist);
			return products;
			
		}
		
		public WebElement getProductName(String listofprods)
		{
			
			WebElement selectedprods = listOfProducts().stream().filter(s->s.findElement(By.cssSelector(".card-body b")).getText().
					   equals(listofprods)).findFirst().orElse(null);
			return selectedprods;
			
		}
		
		public void addProductToCart(String listofprods)
		{
			WebElement selectedprods =getProductName(listofprods);
			selectedprods.findElement(cartbutton).click();
			visibilityOfElement(spinner);
			System.out.println((cartmsg).getText());
			
			
		}
		
}
