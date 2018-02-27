package com.qa.Tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Pages.ContactsPage;
import com.qa.Pages.DealsPage;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TestUtil testUtil;
	
	public  HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialisation();
		testUtil=new TestUtil();
		dealsPage=new DealsPage();
		contactsPage=new ContactsPage();
		loginPage= new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.IMPLICIT_WAIT = 30;
		//testUtil.switchToFrame();
	}
	@Test(priority=1)
	public void verifyHomePageTitle(){
		String homePageTitle = homePage.verifyHomePageTitle();
		System.out.println(homePageTitle);
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.IMPLICIT_WAIT = 20;
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUsername());
	}
	
	@Test(priority=3)
	public void verifyContactlinkTest(){
		testUtil.IMPLICIT_WAIT = 20;
		testUtil.switchToFrame();
		testUtil.IMPLICIT_WAIT = 10;
		contactsPage = homePage.clickOnContactlink();
	}
	
	@Test(priority=4)
	public void verifyDeallinkTest(){
		testUtil.IMPLICIT_WAIT = 20;
		testUtil.switchToFrame();
		testUtil.IMPLICIT_WAIT = 10;
		dealsPage = homePage.clickOnDealLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
