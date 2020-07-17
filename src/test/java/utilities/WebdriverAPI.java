package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverAPI {
	
	
	// Wedriver related methods
	
	public  WebDriver driver;
	public String filepath;

	public  void WaitforFOURseconds() throws Exception {
		Thread.sleep(4000);

	}

	public  String currentURL(WebDriver driver) {
		String URL =driver.getCurrentUrl();
		return URL;

	}
	
	public void NavigatetoURL(String url) {
		driver.get(url);
	}
	
	public void CloseBrowser() {
		driver.quit();
	}
	
	public static  void TypeintoWebElement(WebElement element,String value) {
		element.sendKeys(value);
	}
	
	public void ClickOnElement(WebElement element) {
		element.click();
	}
	
	public WebElement FindElementByXpath(String Xpath) {
		WebElement element =driver.findElement(By.xpath(Xpath));
		return element;
	}

	
	
	//Javascriot realted methods
	
	public void JSclick(WebDriver driver,WebElement element) {

		JavascriptExecutor js2= ((JavascriptExecutor)driver);
		js2.executeScript("arguments[0].click()", element);

	}

	public void JStype(WebDriver driver,WebElement element,String valuee) {

		JavascriptExecutor js2= ((JavascriptExecutor)driver);
		js2.executeScript("arguments[0].value='valuee';", element);

	}

	public void OpenNewtab(WebDriver driver,String url) {

		JavascriptExecutor js7 = (JavascriptExecutor)driver;
		js7.executeScript(url);

	}
	
	public void SctollToButtomoFthePage(WebDriver driver) {
		JavascriptExecutor js3= ((JavascriptExecutor)driver);
		js3.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void ScrollDownToElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js6= ((JavascriptExecutor)driver);
		js6.executeScript("arguments[0].scrollIntoView(true)",element);
	}

	public void takeScreenShots(WebDriver driver) throws Exception {
		
		TakesScreenshot ts = (TakesScreenshot)driver; 
		filepath = System.getProperty("user.dir")+"/screenShots/"+System.currentTimeMillis()+".png";
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(filepath);
		FileUtils.copyFile(source, destination);
		
		//
		
	}
	
	public WebElement  waitForElementVisibility(WebDriver driver, int timeOut, String xpath) {
		
		WebDriverWait wt = new WebDriverWait(driver, timeOut);
		WebElement element =wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return element;
		
		
	}
	
	
	
	

}
