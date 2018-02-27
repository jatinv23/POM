package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class HomePage extends TestBase {

	// OR
	@FindBy(xpath = "//td[contains(text(),'User: Jatin V')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	// @FindBy(xpath=".//*[@id='navmenu']/ul/li[4]/a")
	WebElement contactLink;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealLink;

	@FindBy(xpath = "//a[contains(text(),'New Deal')]")
	WebElement newDealLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUsername() {
		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickOnContactlink() {
		contactLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealLink() {
		dealLink.click();
		return new DealsPage();
	}

	public void performclickOnContact() {
		Actions action1 = new Actions(driver);
		action1.moveToElement(contactLink).build().perform();
	}

	public void performclickOnDeal() {
		Actions action1 = new Actions(driver);
		action1.moveToElement(dealLink).build().perform();
	}

	public void clickOnNewContactlink() {

		Actions action = new Actions(driver);
		action.moveToElement(newContactLink).build().perform();
		newContactLink.click();

	}

	public void clickOnNewDeallink() {

		Actions action1 = new Actions(driver);
		action1.moveToElement(newDealLink).build().perform();
		newDealLink.click();

	}
}
