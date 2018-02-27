package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class DealsPage extends TestBase {

	@FindBy(xpath = "//legend[contains(text(),'Deal')]")
	WebElement dealLabel;

	@FindBy(id = "title")
	WebElement dealTitle;

	@FindBy(xpath = ".//*[@id='prospectForm']//td//input[@name = 'client_lookup']")
	WebElement dealCompany;

	@FindBy(xpath = "//input[@name='contact_lookup']")
	WebElement primaryContact;

	@FindBy(xpath = "//select[@name='type']")
	WebElement typeDropdown;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement savebtn_Deal;

	public DealsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyDeallabel() {
		return dealLabel.isDisplayed();

	}

	public void createNewDeal(String title, String company, String pContact, String type) {
		Select select = new Select(typeDropdown);
		select.selectByVisibleText(type);

		dealTitle.sendKeys(title);
		dealCompany.sendKeys(company);
		primaryContact.sendKeys(pContact);
		savebtn_Deal.click();
	}

}
