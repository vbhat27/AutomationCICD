package rahulshettyacademy.resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReport {

	

	public static ExtentReports config()
	{

		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter exentrep = new ExtentSparkReporter(path);
		exentrep.config().setReportName("Web Automation Results");
		exentrep.config().setDocumentTitle("Test Results");
		
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(exentrep);
		report.setSystemInfo("Tester", "Veena Bhat");	
		report.createTest("Initial Demo");
		return report;
	}
}
