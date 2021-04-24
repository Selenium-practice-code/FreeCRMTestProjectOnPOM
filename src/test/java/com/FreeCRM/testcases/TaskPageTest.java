package com.FreeCRM.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freeCRM.base.TestBase;
import com.freeCRM.pages.HomePage;
import com.freeCRM.pages.LoginPage;
import com.freeCRM.pages.TaskPage;
import com.freeCRM.utilities.Utilities;

public class TaskPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TaskPage taskPage;

	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		taskPage = new TaskPage();
		homePage = loginPage.doLogin(Config.getProperty("username"), Config.getProperty("password"));
		homePage.clickOnTask();

	}

	@Test(priority = 1)
	public void verifyTaskpagelable() {

		boolean flag = taskPage.verifyCreateNewTaskLable();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2, dataProviderClass = Utilities.class, dataProvider = "dp")
	public void taskPageTest(Hashtable<String, String> data) {

		taskPage.clickOnTaskCreateBtn();
		taskPage.createNewTask(data.get("title"), data.get("type"));
	}

	@AfterMethod
	public void closedBrowser() {

		tearDown();
	}

}
