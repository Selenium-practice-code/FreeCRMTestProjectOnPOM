package com.FreeCRM.testcases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freeCRM.base.TestBase;
import com.freeCRM.pages.DealsPage;
import com.freeCRM.pages.HomePage;
import com.freeCRM.pages.LoginPage;
import com.freeCRM.utilities.Utilities;

public class DealsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;

	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new LoginPage();
		dealsPage = new DealsPage();
		homePage = loginPage.doLogin(Config.getProperty("username"), Config.getProperty("password"));
 
		 
		homePage.clickOnDeals();

	}

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void dealsPageTest(Hashtable<String, String> data) {

		dealsPage.clickonCreateDeals();
		dealsPage.fillTheFormofCreateDeals(data.get("tittle"));

	}

	@AfterMethod
	public void closedBrowser() {

		tearDown();
	}

}
