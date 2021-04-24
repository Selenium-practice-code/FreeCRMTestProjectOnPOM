package com.freeCRM.utilities;
/*************************************** PURPOSE **********************************

 - This class implements the WebDriverEventListener, which is included under events.
 The purpose of implementing this interface is to override all the methods and define certain useful  Log statements 
 which would be displayed/logged as the application under test is being run.

 Do not call any of these methods, instead these methods will be invoked automatically
 as an when the action done (click, findBy etc). 

 */

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.freeCRM.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
		log.info("Before navigating to: '" + url + "'");
		test.log(LogStatus.INFO, "Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
		log.info("Navigated to:'" + url + "'");
		test.log(LogStatus.INFO, "Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");
		log.info("Value of the:" + element.toString() + " before any changes made");
		test.log(LogStatus.INFO, "Value of the:" + element.toString() + " before any changes made");
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
		log.info("Element value changed to: " + element.toString());
		test.log(LogStatus.INFO, "Element value changed to: " + element.toString());
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
		log.info("Trying to click on: " + element.toString());
		test.log(LogStatus.INFO, "Trying to click on: " + element.toString());
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
		log.info("Clicked on: " + element.toString());
		test.log(LogStatus.INFO, "Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
		log.info("Navigating back to previous page");
		test.log(LogStatus.INFO, "Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
		log.info("Navigating back to previous page");
		test.log(LogStatus.INFO, "Navigating back to previous page");
	}
	

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
		log.info("Navigating forward to next page");
		test.log(LogStatus.INFO, "Navigating forward to next page");
	}
	

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
		log.info("Navigating forward to next page");
		test.log(LogStatus.INFO, "Navigating forward to next page");
	
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error);
//		log.info("Exception occured: " + error);
//		test.log(LogStatus.ERROR, "Exception occured: " + error );
	
//		try {
//			Utilities.captureScreenshot();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
		log.info("Trying to find Element By : " + by.toString());
		test.log(LogStatus.INFO, "Trying to find Element By : " + by.toString());
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
		log.info("Found Element By : " + by.toString());
		test.log(LogStatus.INFO, "Found Element By : " + by.toString());
	}

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver) {
	}

	public void afterScript(String script, WebDriver driver) {
	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

}