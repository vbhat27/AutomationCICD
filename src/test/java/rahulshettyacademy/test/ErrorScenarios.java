package rahulshettyacademy.test;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.Base.BaseTest;
public class ErrorScenarios extends BaseTest{

		@Test(groups= {"Error Handlings"})
		public void validateloginerror() throws InterruptedException
		{
			
			
		login.Logindetails("helloveena@gmail.com", "Veena1234");
		Assert.assertEquals("Incorrect email password.", login.getErrorMsg());

		
		
		}
	

}
