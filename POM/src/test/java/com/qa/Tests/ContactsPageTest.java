package com.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Pages.ContactsPage;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialisation();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.IMPLICIT_WAIT = 50;
		testUtil.switchToFrame();
		testUtil.IMPLICIT_WAIT = 30;
		contactsPage = homePage.clickOnContactlink();
	}
	
	
	@Test(priority=1)
	public void contactsPagelabel(){
		TestUtil.IMPLICIT_WAIT = 40;
		homePage.performclickOnContact();
		TestUtil.IMPLICIT_WAIT = 40;
		homePage.clickOnNewContactlink();
		testUtil.IMPLICIT_WAIT = 10;
		Assert.assertTrue(contactsPage.verifyContactLabel(), "Contact Information");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 2,dataProvider="getCRMTestData")
	public void validateNewContact(String title, String firstName, String lastName){
		TestUtil.IMPLICIT_WAIT = 10;
		homePage.performclickOnContact();
		testUtil.IMPLICIT_WAIT = 40;
		homePage.clickOnNewContactlink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter");
		contactsPage.createNewContact(title, firstName, lastName);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
