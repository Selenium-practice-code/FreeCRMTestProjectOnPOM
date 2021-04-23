package com.freeCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freeCRM.base.TestBase;

public class LoginPage extends TestBase {

	// page factory elememts
	@FindBy(xpath = "//header/div[1]/nav[1]/div[2]/div[1]/a[1]")
	 
	private WebElement logInBtn;

	@FindBy(name = "email")
	@CacheLookup
	private WebElement username;

	@FindBy(name = "password")
	@CacheLookup
	private WebElement password;

	@FindBy(xpath = "//div[contains(text(),'Login')]")
	@CacheLookup
	private WebElement signInBtn;

	@FindBy(xpath = "//body/div[1]/main[1]/section[1]/a[1]")
	@CacheLookup
	private WebElement signUpBtn;

	@FindBy(xpath = "//body[1]/div[1]/header[1]/div[1]/nav[1]/div[2]/div[1]/div[1]/div[1]/a[1]/span[2]")
	@CacheLookup
	private WebElement crmLogo;

	// create a constructor for PageFactory
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	// Methods

	public String validateLoginPageTitle() {

		return driver.getTitle();
	}

	public boolean validateCrmImage() {

		return crmLogo.isDisplayed();
	}

	public HomePage doLogin(String userName, String Password) {

	
		 logInBtn.click();
		 username.sendKeys(userName);
		 password.sendKeys(Password);
		 signInBtn.click();
		return new HomePage();

	}

}
