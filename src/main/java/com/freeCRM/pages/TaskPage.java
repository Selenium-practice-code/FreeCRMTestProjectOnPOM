package com.freeCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freeCRM.base.TestBase;

public class TaskPage extends TestBase {

	// Page Locators

	@FindBy(xpath = "//button[normalize-space()='Create']")
	private WebElement taskCreateBtn;

	@FindBy(xpath = "//input[@name='title']")
	private WebElement titleTextBox;

	@FindBy(xpath = "//body/div[@id='ui']/div/div/div[@id='main-content']/div/div/form/div[2]/div[2]/div[1]/div[1]")
	private WebElement typeDropDown;

	@FindBy(xpath = "//body/div[@id='ui']/div/div/div[@id='main-content']/div/div[@id='dashboard-toolbar']/div[1]")
	private WebElement  taskLable;

	// create a constructor for PageFactory

	public TaskPage() {

		PageFactory.initElements(driver, this);
	}

	// Methods

	public boolean verifyCreateNewTaskLable() {

		return taskLable.isDisplayed();
	}

	public void clickOnTaskCreateBtn() {

		taskCreateBtn.click();
	}

	public void createNewTask(String title, String type) {

		titleTextBox.sendKeys(title);
		typeDropDown.sendKeys(type);

	}

}
