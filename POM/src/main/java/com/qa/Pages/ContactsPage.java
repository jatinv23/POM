package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	//OR
	@FindBy(xpath="//fieldset/legend[contains(text(),'Contact Information')]")
	WebElement Contactlabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy( name="title")
	WebElement titledropdown;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement savebtn;
	
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLabel(){
		return Contactlabel.isDisplayed();
	}
	
	public void createNewContact(String title, String ftname, String ltname){
		Select select = new Select(titledropdown);
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftname);
		lastName.sendKeys(ltname);
		savebtn.click();
		
		
	}

}
