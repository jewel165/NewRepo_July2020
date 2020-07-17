package testSets;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import basicSetup.BasicSetUp;
import locators.AZcart_Page;
import locators.AmazonHomepage_Page;

public class AmazonCart_Test extends BasicSetUp  {
	AZsearch_Test ss = new AZsearch_Test();
	AZcart_Page ct = new AZcart_Page();
	public AmazonHomepage_Page loc = new AmazonHomepage_Page();
	
	@Test
	public void testAmazonCart() throws Exception {
		test=report.createTest("testAmazonCart");
		//ss.AmazonSearch();
		WebElement SearchbAR =FindElementByXpath(loc.SearchBAR_xpath);
		TypeintoWebElement(SearchbAR, "ps5");
		WebElement SearchButton = FindElementByXpath(loc.SreachButton_xapth);
		ClickOnElement(SearchButton);
		WaitforFOURseconds();
		
		WebElement ps4 = waitForElementVisibility(driver, 10, ct.ps4PRO);
		ps4.click();WaitforFOURseconds();
		
		WebElement buyingOption = waitForElementVisibility(driver, 10, ct.buyingOption);
		buyingOption.click();WaitforFOURseconds();
		
		WebElement addTocart = waitForElementVisibility(driver, 10, ct.ADDtocart_PS4);
		addTocart.click();WaitforFOURseconds();
		
		WebElement cart = waitForElementVisibility(driver, 10, ct.cartView);
		cart.click();
		
		if(driver.getCurrentUrl().contains("url")==true) {
			test.log(Status.INFO, "successfully navigated to Cart Page");
		}
		else {
			test.log(Status.ERROR, "Unanle to load Cart Page");
		}
		
		test.log(Status.INFO, "<<<<<<<<-------Verigiying sub-Total------>>>>>>>>");
		
		WebElement subTotal1 = waitForElementVisibility(driver, 10, ct.SubTotal_CheckoutSection);
		String total1 = subTotal1.getText();
		System.out.println(total1);
		
		WebElement subTotal2 = waitForElementVisibility(driver, 10, ct.SubTotal_ItemSection);
		String total2 = subTotal2.getText();
		System.out.println(total2);
		
		if(total1.equalsIgnoreCase(total2)) {
			test.log(Status.INFO, "The Sub-Total of cart value matches in botch sections");
		}
		else {
			test.log(Status.ERROR, "The Sub-Total of cart value DOES NOT match");
		}
		
		WebElement checkout = waitForElementVisibility(driver, 10, ct.Checkout);
		checkout.click();WaitforFOURseconds();
		
		test.log(Status.INFO, "Clicked on checkout Button");
		
		if(driver.getCurrentUrl().contains("signin?")) {
			test.log(Status.INFO, "sign is page is loaded as expected");
		}
		else {
			test.log(Status.ERROR, "sign is page is NOT loaded");
		}
		
		
		
		
		
	}

}
