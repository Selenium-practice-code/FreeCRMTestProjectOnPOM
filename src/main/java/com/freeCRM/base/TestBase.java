package com.freeCRM.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.freeCRM.utilities.ExcelReader;
import com.freeCRM.utilities.ExtentManager;
import com.freeCRM.utilities.Waits;
import com.freeCRM.utilities.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {

	public static WebDriver driver;
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(TestBase.class);
	public static String browser;
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");
	

	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static WebEventListener eventListener;
	public  static EventFiringWebDriver e_driver;

	public static void initialization() {

		// Create a Time Stamp for logs
		Date d = new Date();
		System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));

		// Configure the logger file
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");

		if (browser == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/properties/Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Config.load(fis);

				log.info("Config propertiy file loaded.");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Launching the Browsers using Config properties file
		if (Config.getProperty("browser").equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver");
			driver = new ChromeDriver();

			log.info("Chrome Browser Launched.");

		} else if (Config.getProperty("browser").equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/test/resources/executables/geckodriver");
			driver = new FirefoxDriver();

			log.info("Chrome Browser Launched.");

		} else if (Config.getProperty("browser").equals("safari")) {

			driver = new SafariDriver();
			log.info("Safari Browser Launched.");
		}
		

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;


		driver.get(Config.getProperty("testSiteURL"));
		log.info("Naviated to : -> " + Config.getProperty("testSiteURL"));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Waits.IMPLICIT_WAIT));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Waits.PAGE_LOAD_TIMEOUT));
		

		
	}

	public void switchToFrame(String frameName) {

		driver.switchTo().frame(frameName);
		
	}
	
	

	public void tearDown() {

		if (driver != null) {

			driver.quit();
		}

		log.info("Test executed successfully!!");

	}

}
