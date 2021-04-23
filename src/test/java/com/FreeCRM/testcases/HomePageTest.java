package com.FreeCRM.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import com.freeCRM.base.TestBase;
import com.freeCRM.pages.ContactsPage;
import com.freeCRM.pages.HomePage;
import com.freeCRM.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	 
	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.doLogin(Config.getProperty("username"), Config.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {

		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "HomePage title not matched.");

	}

	@Test(priority = 2)
	public void verifyUserNameTest() {

		boolean flag = homePage.verifyCurrectUsername();
		Assert.assertTrue(flag);

	}

	@Test(priority = 3)
	public void goToContactsLinkTest() {

		
		contactsPage = homePage.clickOnContacts();
		 
		
		  
	}

	@AfterMethod
	public void closedBrowsers() {

		tearDown();
	}

}
