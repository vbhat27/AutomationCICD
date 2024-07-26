package rahulshettyacademy.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LoginPageDetails;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPageDetails login;
	
	public WebDriver initializations() throws IOException {
		
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademy//resources//GlobalData.properties");
		prop.load(fis);
		String browsersite = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if(browsersite.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			
			if(browsersite.contains("headless"))
			{
				options.addArguments("headless");
				
			}
			
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1400,900));
		}
		else if(browsersite.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver", "/Users/LENOVO//Downloads//geckodriver.exe\"");
			driver = new FirefoxDriver();
		}
		else if(browsersite.equals("edge"))
		{
			
		}
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public LoginPageDetails baselogindetails() throws IOException
	{
	     driver = initializations();
	     login = new LoginPageDetails(driver);
	     return login;
	     
	}
	
	@AfterTest(alwaysRun=true)
	public void browserclosing(WebDriver driver) throws InterruptedException
	{
		this.driver=driver;
		driver.close();
		
	}
	
	public String getScreenshot(String testCaseName) throws IOException 
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}
	
	public String getScreenshotBase64() throws IOException 
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		String base64 = ts.getScreenshotAs(OutputType.BASE64);
		return base64;
	}
	
     public List<HashMap<String, String>> getJasonData(String filepath) throws IOException {
		
		
		String jsoncontent = FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		List<HashMap<String,String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;
}

}