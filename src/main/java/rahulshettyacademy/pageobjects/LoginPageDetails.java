package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstarctComponents;

public class LoginPageDetails extends AbstarctComponents{

		WebDriver driver;

		public LoginPageDetails(WebDriver driver)
		{
			
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);

			
		}
		
		@FindBy(id="userEmail")
		WebElement email;
		
		@FindBy(id="userPassword")
		WebElement password;
		
		@FindBy(id="login")
		WebElement submit;
		
		@FindBy (css="[class*=flyInOut]")
		WebElement loginerror;
		//ng-tns-c4-11 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error
		
		public ProductCatalogue Logindetails(String emailID, String userpassword)
		{
			
			email.sendKeys(emailID);
			password.sendKeys(userpassword);
			submit.click();
			ProductCatalogue prod = new ProductCatalogue(driver);
			return prod;
		}
		
		public void UrlDetails()
		{
			
			driver.get("https://rahulshettyacademy.com/client");
			
		}
		
		public String getErrorMsg() throws InterruptedException
		{
			//Thread.sleep(1000);
			waitforElementtoappear(loginerror);
			String error = loginerror.getText();
			return error;
		}

}
