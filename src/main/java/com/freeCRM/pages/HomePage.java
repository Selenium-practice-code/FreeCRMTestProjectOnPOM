package com.freeCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freeCRM.base.TestBase;

public class HomePage extends TestBase {

	// elements
	@FindBy(xpath = "//span[contains(text(),'sumit agnihotri')]")
	@CacheLookup
	private WebElement userNameLabel;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	@CacheLookup
	private WebElement contactsLink;

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	@CacheLookup
	private WebElement dealsLink;

	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	@CacheLookup
	private WebElement tasksLink;

	// Constructor for PageFactory
	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	// Methods
	public String verifyHomePageTitle() {

		return driver.getTitle();
	}

	public boolean verifyCurrectUsername() {

		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickOnContacts() {

		contactsLink.click();

		return new ContactsPage();
	}

	public DealsPage clickOnDeals() {

		 dealsLink.click();

		return new DealsPage();
	}

	public TaskPage clickOnTask() {

		 tasksLink.click();
		 

		return new TaskPage();
	}

}
