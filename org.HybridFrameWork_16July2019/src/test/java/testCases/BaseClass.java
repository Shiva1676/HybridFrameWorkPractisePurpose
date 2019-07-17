/**
 * 
 */
package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

import dataProvider.DataProvider;
import factory.Browser;

/**
 * @author Lenovo
 *
 */
public class BaseClass {

	WebDriver driver;

	ExtentReports report;

	@BeforeSuite
	public void setReport() {

		String path = System.getProperty("user.dir") + "/Reports/HRM" + System.currentTimeMillis() + ".html";

		report = new ExtentReports(path);
	}

	@AfterSuite
	public void closeReport() {

		report.flush();
	}

	@BeforeClass
	public void setBrowser() {

		driver = Browser.startBrowser(DataProvider.getConfig().getBrowser(), DataProvider.getConfig().getURL());
	}

	@AfterClass
	public void closeBrower() {

		driver.close();
	}

}
