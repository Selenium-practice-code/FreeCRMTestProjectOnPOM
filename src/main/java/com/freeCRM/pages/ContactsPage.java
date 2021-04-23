package com.freeCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freeCRM.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//a[@href='/contacts/new']")
	@CacheLookup
	private WebElement createContats;

	@FindBy(xpath = "//input[@name='first_name']")
	@CacheLookup
	private WebElement firstName;

	@FindBy(xpath = "//input[@name='last_name']")
	@CacheLookup
	private WebElement lastName;

	@FindBy(xpath = "//button[@class='ui linkedin button']")
	@CacheLookup
	private WebElement saveBtn;

	// Constructor

	public ContactsPage() {

		PageFactory.initElements(driver, this);
	}

	// Methods

	public void clickOnCreate() {

		createContats.click();

	}

	public void createNewContact(String fname, String lname) {

		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		saveBtn.click();

	}

}
