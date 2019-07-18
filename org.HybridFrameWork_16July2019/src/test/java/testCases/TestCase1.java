/**
 * 
 */
package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProvider.DataProvider;
import pages.LogOutPage;
import pages.LoginPage;
import utility.Helper;

/**
 * @author Lenovo
 *
 */
public class TestCase1 extends BaseClass {

	ExtentTest logger;

	boolean status;

	@BeforeMethod
	public void reporting() {

		logger = report.startTest("OrangeHRM INFO");
	}

	@AfterMethod
	public void tearDownReporting(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			logger.log(LogStatus.FAIL, logger.addScreenCapture(Helper.captureScreenShot(driver)));
		}

		report.endTest(logger);
	}

	@Test
	public void verifyLogin() {
		
		// This is for login page
		// Created By: Ganesh
		// Created On: 16-07-2019

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		LogOutPage logout = PageFactory.initElements(driver, LogOutPage.class);

		int rows = DataProvider.getExcel().getRows("Sheet1");

		int columns = DataProvider.getExcel().getColumns("Sheet1");

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < columns - 1; j++) {

				status = login.loginPage(DataProvider.getExcel().getData("Sheet1", i, j),
						DataProvider.getExcel().getData("Sheet1", i, j + 1));

				if (status == true) {

					logger.log(LogStatus.PASS, "User is able to login");

					logout.logOutApp();

				} else {

					logger.log(LogStatus.FAIL, "User is not able to login");

					// Assert.assertTrue(status);

				}

			}

		}
		Assert.assertTrue(status);
	}

	// login.loginPage("Admin", "admin123");

}
