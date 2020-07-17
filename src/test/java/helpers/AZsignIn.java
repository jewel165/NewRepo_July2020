package helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import basicSetup.BasicSetUp;
import locators.AmazonHomepage_Page;
import utilities.DataDriver;







public class AZsignIn extends  BasicSetUp {

	AmazonHomepage_Page loc = new AmazonHomepage_Page();
	DataDriver dd = new DataDriver();

	String xlFile1 = "/Users/jewel/WorkSpace/eclipse-workspace/MYframeworkJuly2020/userinfo.xlsx";


	@DataProvider(name = "loginInfo")
	public Object [][]getLogInInfo() throws Exception {


		int rowcount =dd.getRowCount(xlFile1, 1);
		int cellcount = dd.getCellCount(xlFile1, 1, 1);

		Object [] [] TestData = new Object[rowcount][cellcount];

		for(int a = 1;a<=rowcount;a++) {

			for(int b=0;b<cellcount;b++) {

				TestData [a-1][b]=dd.getCellData(xlFile1, 1, a, b);

			}
		}
		return TestData;


	}

	@DataProvider(name = "loginInfo2")
	public Object [][] GetLogInInfo2() throws Exception{

		FileInputStream fin = new FileInputStream(xlFile1);
		XSSFWorkbook wb = new XSSFWorkbook(fin);
		XSSFSheet st = wb.getSheetAt(1);
		XSSFRow rw = st.getRow(1);
		XSSFCell cl = rw.getCell(0);

		int rowcount = st.getLastRowNum();
		int cellcount = rw.getLastCellNum();

		Object [] [] TestData = new Object[rowcount][cellcount];

		for(int a = 1;a<=rowcount;a++) {

			for(int b=0;b<cellcount;b++) {

				TestData [a-1][b]= st.getRow(a).getCell(b).getStringCellValue();

			}

		}
		return TestData;
		

	}
	
	@DataProvider(name = "signUpinfo")
	public Object [][] getSignupInfo() throws Exception{
		
		int rowcount = dd.getRowCount(xlFile1, 2);
		int cellcount = dd.getCellCount(xlFile1, 2, 1);
		
		Object [] [] TestData = new Object[rowcount][cellcount];
		
		for(int a = 1;a<=rowcount;a++) {

			for(int b=0;b<cellcount;b++) {

				TestData [a-1][b]=dd.getCellData(xlFile1, 2, a, b);

			}
		}
		return TestData;
	}
	
	
	@Test(dataProvider = "signUpinfo",enabled = false)
	public void AMAZONsignUp(String name,String email,String pass,String rePassword)  {
		
		try {
			driver.findElement(By.xpath("//*[@id='nav-link-accountList']/span[1]")).click();Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='createAccountSubmit']")).click();Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@id=\"ap_customer_name\"]")).sendKeys(name);
			driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(email);
			driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(pass);
			driver.findElement(By.xpath("//*[@id=\"ap_password_check\"]")).sendKeys(rePassword);
			
			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(Status.ERROR, "webdriver crashed due to timepout isssue");
		}
		
		driver.findElement(By.xpath("sdhsadhsdjsdh")).click();
		driver.findElement(By.xpath("dnskdcfnks")).click();
		driver.findElement(By.xpath("sdhsadhsdjsdh")).sendKeys("absdjhasdjhas");
		
	}


	@Test(dataProvider = "loginInfo2",enabled = true)
	void AZlogin(String email, String password) throws Exception {
		//NavigatetoURL(AMAZOM);
		test=report.createTest(" Amazon Log-In");
		test.log(Status.INFO, "Navigating to The URL");
		
		
		
			try {
				test.log(Status.INFO, "LOcationg Account Management Element");
				WebElement AccountManagement = FindElementByXpath(loc.AccountMangement_xapth);
				test.log(Status.INFO, "Clicking On Account Management");
				ClickOnElement(AccountManagement);
				test.log(Status.INFO, "Inputting Email info");
				WebElement EmailField = FindElementByXpath(loc.EmailEditfield_xpath);
				TypeintoWebElement(EmailField, email);
				test.log(Status.INFO, "Clicking oN coNTINUE bUTTON");
				WebElement ConButton = FindElementByXpath(loc.continueButton_xpath);
				ClickOnElement(ConButton);
				test.log(Status.INFO, "Inputting USER password");
				WebElement PassEdiTfIELD = FindElementByXpath(loc.Password_xpath);
			} catch (StaleElementReferenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		driver.navigate().back(); 
			Thread.sleep(3000);
			
	//		#Tast 1
			try {
				
			}
			catch(StaleElementReferenceException st) {
				st.printStackTrace();
			}
			
		// #Tsk 2
			
			try {
				
			}
			catch(ElementNotInteractableException io) {
				io.printStackTrace();
			}
			
			//task 3
		
		
	}

	@Test(dependsOnMethods = "AZlogin",enabled = false)
	void AzLogOut() {
		test=report.createTest("Amazon lOG-OUT");

		//test.log(Status.INFO, "Navigating to The URL");
		test.log(Status.INFO, "Today is 25th of June 2020");
		System.out.println("Amazon lOGoUT");
		test.log(Status.INFO, "Successfully Signed out from Amazon");
		test.log(Status.WARNING, "This TC needs work to do, No code was pROVIDED");
	}

	@Test()
	void AmazonTittle() {
		test=report.createTest("Amazon Title");

		//test.log(Status.FATAL, "this is just  tEST");
		test.log(Status.INFO, "Checking Expected Title");
		String title = driver.getTitle();
		System.out.println(title);

		if(title.equalsIgnoreCase("Amazon")) {
			test.log(Status.INFO, "The Tilte is As Expected");

		}
		else {
			test.log(Status.ERROR, "The Tilte is NOT As Expected");
		}


	}

}
