package testSets;

import org.testng.annotations.Test;

import basicSetup.BasicSetUp;
import locators.AmazonHomepage_Page;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class AZsearch_Test extends BasicSetUp{
	
	//WebDriver driver;
	
	String AMAZOM = "https://www.amazon.com";
	AmazonHomepage_Page loc = new AmazonHomepage_Page();
	
	
	@Test(enabled = true, groups = {"AZtest","Random","az001","june15thFailure"})
	public void AmazonSearch() throws Exception {
		test=report.createTest("Amazon Search");
		
		//NavigatetoURL(AMAZOM);
		WebElement SearchbAR =FindElementByXpath(loc.SearchBAR_xpath);
		TypeintoWebElement(SearchbAR, "ps5");
		WebElement SearchButton = FindElementByXpath(loc.SreachButton_xapth);
		ClickOnElement(SearchButton);
		WaitforFOURseconds();
		//CloseBrowser();
		
	}
	
	
	
	
	
	@Test(groups = {"az002","june15thFailure"}, enabled = false)
	void DemoTest1() {
		test=report.createTest("Amazom Random 2");
		
		System.out.println("This is a demo tEST");
		int a=10;
		int b=15;
		Assert.assertEquals(a, b);
				
	}
	
}
