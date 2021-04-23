package com.FreeCRM.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import com.freeCRM.base.TestBase;
import com.freeCRM.pages.ContactsPage;
import com.freeCRM.pages.HomePage;
import com.freeCRM.pages.LoginPage;
import com.freeCRM.utilities.Utilities;

public class ContactsPageTest extends TestBase {

	 
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	 
	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.doLogin(Config.getProperty("username"), Config.getProperty("password"));
		homePage.clickOnContacts();

	}

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void  contactsPageTest(Hashtable<String, String> data) {

		contactsPage.clickOnCreate();
		contactsPage.createNewContact(data.get("firstname"), data.get("lastname"));
		
		 
	 
	}

	@AfterMethod
	public void closedBrowser() {

		tearDown();
	}

}
