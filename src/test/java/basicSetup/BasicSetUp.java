package basicSetup;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.WebdriverAPI;




public class BasicSetUp extends WebdriverAPI{
	
	//String AMAZOM = "https://www.amazon.com";
	//LocatorClass loc = new LocatorClass();
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	

	
	
	@BeforeSuite
	public void SetuoReporter() {
		
		reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/report.html");
		report = new ExtentReports();
		report.attachReporter(reporter);
		
		//Config Your Reporter
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Amazon Test Reports");
		
		report.setSystemInfo("Author", "MD Alam");
		report.setSystemInfo("Environment", "UAT");
		report.setSystemInfo("Browser", "Chrome 83");
		report.setSystemInfo("Sprint", "27");
		report.setSystemInfo("Languange", "Java");
		
		
		
		
	}
	
	
	@AfterSuite
	public void cleanup() {
		report.flush();
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void BeforeMethods() {
		
	
			// dont forget to change driver for windows OS. ex:chromedriver.exe
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");// sets the driver// car ingintion
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//System.out.println("Navigating to Amazon");

			driver.get("https://www.amazon.com");
			
		
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void AFTERMETHODS(ITestResult result) throws Exception {
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "This test Case Passes");
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "This Test Case Failed");
			test.log(Status.FAIL, result.getThrowable());
			takeScreenShots(driver);
			test.addScreenCaptureFromPath(filepath);
			
		}
		
	
		CloseBrowser();
	}
	

	
	

}
