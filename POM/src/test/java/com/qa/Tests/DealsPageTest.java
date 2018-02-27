package com.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Pages.ContactsPage;
import com.qa.Pages.DealsPage;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class DealsPageTest extends TestBase  {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	String sheetName = "deals";

	 public DealsPageTest(){
		 super();
	 }
	 
	 @BeforeMethod
	 public void setUp(){
		 initialisation();
			testUtil = new TestUtil();
			loginPage = new LoginPage();
			dealsPage = new DealsPage();
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			testUtil.IMPLICIT_WAIT = 50;
			testUtil.switchToFrame();
			testUtil.IMPLICIT_WAIT = 30;
			dealsPage = homePage.clickOnDealLink();
	 }
	 
	 @Test(priority = 1)
	 public void dealsPagelabel(){
			TestUtil.IMPLICIT_WAIT = 40;
			homePage.performclickOnDeal();
			TestUtil.IMPLICIT_WAIT = 40;
			homePage.clickOnNewContactlink();
			testUtil.IMPLICIT_WAIT = 10;
			Assert.assertTrue(dealsPage.verifyDeallabel(), "Deal");
		}
	 
	 @DataProvider
		public Object[][] getCRMTestData(){
			Object data[][] = TestUtil.getTestData(sheetName);
			return data;
		}
	 
	 @Test(priority = 2,dataProvider="getCRMTestData")
	 public void validateDeal(String title, String company, String p_Contact, String type){
		 TestUtil.IMPLICIT_WAIT = 10;
			homePage.performclickOnDeal();
			testUtil.IMPLICIT_WAIT = 40;
			homePage.clickOnNewDeallink();
			//contactsPage.createNewContact("Mr.", "Tom", "Peter");
			dealsPage.createNewDeal(title, company, p_Contact, type);
		 
	 }
	 
	 @AfterMethod
		public void tearDown(){
			driver.quit();
		}
}
