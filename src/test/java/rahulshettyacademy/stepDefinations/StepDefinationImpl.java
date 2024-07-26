package rahulshettyacademy.stepDefinations;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.Base.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.LoginPageDetails;
import rahulshettyacademy.pageobjects.OrderDetailsPage;
import rahulshettyacademy.pageobjects.PaymentMethod;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StepDefinationImpl extends BaseTest{

	public LoginPageDetails login;
	public ProductCatalogue prod;
	public CartPage cart;
	public PaymentMethod pay;
	public OrderDetailsPage order;
	
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException{
		
		login=baselogindetails();
		
	}
	@Given ("^Logged in with (.+) and password (.+)$")
	public void Logged_in_with_name_and_password_password(String userName,String password)
	{
		prod = login.Logindetails(userName,password);
	}
	
	@When("^I add product (.+) to Cart$")
	public void I_add_product_productName_to_Cart(String productName)
	{
		prod.listOfProducts();
		prod.getProductName(productName);
		prod.addProductToCart(productName);
		
	}
	
	@And("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName) throws InterruptedException
	{
		cart = prod.cartbuttonclick();
		boolean check = cart.cartdetails(productName);
		Assert.assertTrue(check);
		PaymentMethod pay = cart.checkoutbutton();
		order = pay.countrySelection("India");
	
	}
	@Then ("{string} messag is displayed on ConfirmationPage")
	public void message_displayed_on_ConfirmationPage(String string)
	{
		String msg = order.orderDetailsPage();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
	}
	@Then ("{string} message is displayed")
	public void message_is_displayed(String string) throws InterruptedException
	{
		Assert.assertEquals(string, login.getErrorMsg());
		driver.close();
		
	}
	
}
