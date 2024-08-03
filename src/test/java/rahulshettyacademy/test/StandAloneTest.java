package rahulshettyacademy.test;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyacademy.Base.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderDetailsPage;
import rahulshettyacademy.pageobjects.OrdersPage;
import rahulshettyacademy.pageobjects.PaymentMethod;
import rahulshettyacademy.pageobjects.ProductCatalogue;
public class StandAloneTest extends BaseTest{
	String listofprods = "ZARA COAT 3";
	@Test(dataProvider="getData", groups={"Purchase Order"})
	public void totalsubmission (HashMap<String,String> input) throws IOException, InterruptedException {
		
		
		//THIS IS TO TEST WEBHOOKS
		String country = "India";
		ProductCatalogue prod = login.Logindetails(input.get("emailID"), input.get("userpassword"));
		prod.listOfProducts();
		prod.getProductName(input.get("products"));
		prod.addProductToCart(input.get("products"));
		CartPage cart = prod.cartbuttonclick();
		boolean check = cart.cartdetails(input.get("products"));
		Assert.assertTrue(check);
		PaymentMethod pay = cart.checkoutbutton();
		OrderDetailsPage order = pay.countrySelection(country);
		String msg = order.orderDetailsPage();
		
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println();
		
		
		
//		prod.countrySelection(country);
//		
//		prod.placeorder();
//		prod.orderDetailsPage(confirmmsg);

		
//		
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".totalRow button")));
//		driver.findElement(By.cssSelector(".totalRow button")).click();
//		driver.findElement(By.className("input txt")).sendKeys("123");
		
	
		
//		Actions act = new Actions(driver);
//		
//		act.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')]) [2]")).click();
//		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		Thread.sleep(1000);
//		js.executeScript("window.scrollBy(0,500)");
//		
//		act.moveToElement(driver.findElement(By.cssSelector(".action__submit"))).click().build().perform();
//		
//		String confirmmsg="THANKYOU FOR THE ORDER.";
//		
//		String confirm = driver.findElement(By.cssSelector(".hero-primary")).getText();
//		
//		Assert.assertEquals(confirm, confirmmsg);
		
	//	
		
		
		
	}
	
	@Test(dependsOnMethods= {"totalsubmission"})
	public void ordersPage()
	{
		
		login.Logindetails("helloveena@gmail.com", "Veena123");
		OrdersPage order = login.ordersbuttonclick();
		boolean check = order.listOfProducts(listofprods);
		Assert.assertTrue(check);
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException  {
		
//		HashMap<String,String> map = new HashMap<String,String>(); 
//		map.put("emailID", "helloveena@gmail.com");
//		map.put("userpassword", "Veena123");
//		map.put("products", "ZARA COAT 3");
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("emailID", "prashantchinc123@gmail.com");
//		map1.put("userpassword", "Veena123");
//		map1.put("products", "IPHONE 13 PRO");
		
		List<HashMap<String,String>> map = getJasonData(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\Properties2.json");
		return new Object[][] {{map.get(0)},{map.get(1)}};
		
		
		
	}


}
