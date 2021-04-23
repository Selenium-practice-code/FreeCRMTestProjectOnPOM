package com.freeCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freeCRM.base.TestBase;

public class DealsPage extends TestBase {

	@FindBy(xpath = "//button[normalize-space()='Create']")
	private WebElement createDeal;

	@FindBy(xpath = "//input[@name='title']")
	private WebElement tittleName;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement saveBtn;

	public DealsPage() {

		PageFactory.initElements(driver, this);
	}

	public void clickonCreateDeals() {

		 createDeal.click();

	}

	public void fillTheFormofCreateDeals(String title) {

		 tittleName.sendKeys(title);
	}

}
