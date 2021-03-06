package com.freeCRM.listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.freeCRM.base.TestBase;
import com.freeCRM.utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListeners extends TestBase implements ITestListener, ISuiteListener {

	public String messageBody;

	@Override
	public void onStart(ISuite suite) {

	}

	@Override
	public void onFinish(ISuite suite) {

//		// Send Automatic Mail
//		MonitoringMail mail = new MonitoringMail();
//
//		try {
//			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
//					+ ":8080/job/DataDrivenFrameworkLiveProject/Extent_20Reports/";
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
//		} catch (AddressException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@Override
	public void onTestStart(ITestResult result) {

		// Tell the Extent report to start the Test
		test = rep.startTest(result.getName().toUpperCase());

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		// Extent log
		test.log(LogStatus.PASS, result.getName().toUpperCase() + "PASS");
		rep.endTest(test);
		rep.flush();

	}

	@Override
	public void onTestFailure(ITestResult result) {

		// Flag for generating HTML Reportng report
		System.setProperty("org.uncommons.reportng.escape-output", "false");

		// Capturing Screenshot
		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Extent Report
		test.log(LogStatus.FAIL, result.getName().toUpperCase() + "Failed with exception :  " + result.getThrowable());
		// Add Screenshot in Extent Report
		test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));

		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src=" + Utilities.screenshotName
				+ " height=100 width=100></img></a>");
		rep.endTest(test);
		rep.flush();

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		// Extent Report
		test.log(LogStatus.SKIP, result.getName().toUpperCase() + "Skipped the test as the Run mode is No.");
		rep.endTest(test);
		rep.flush();

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}
