package com.FreeCRM.testcases;

import java.util.Hashtable;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freeCRM.base.TestBase;
import com.freeCRM.pages.HomePage;
import com.freeCRM.pages.LoginPage;
import com.freeCRM.utilities.Utilities;

public class LoginTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	 
	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new LoginPage();
	    homePage = new HomePage();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {

		String title = loginPage.validateLoginPageTitle();
		AssertJUnit.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
	}

	@Test(priority = 2)
	public void crmLogoImageTest() {

		boolean flag = loginPage.validateCrmImage();
		AssertJUnit.assertTrue(flag);
	}

	@Test(priority = 3, dataProviderClass = Utilities.class, dataProvider = "dp")
	
	public void loginTest(Hashtable<String, String> data) {

		homePage = loginPage.doLogin(data.get("username"), data.get("password"));

	}

	@AfterMethod
	public void closedBrowser() {

		tearDown();
	}

}
