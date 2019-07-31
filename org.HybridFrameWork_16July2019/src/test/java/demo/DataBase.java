/**
 * 
 */
package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.Helper;

/**
 * @author Lenovo
 *
 */
public class DataBase {

	WebDriver driver;

	ExtentReports report;
	ExtentTest logger;
	boolean status = false;

	@BeforeSuite
	public void setReport() {

		String path = System.getProperty("user.dir") + "/Reports/HRM" + System.currentTimeMillis() + ".html";

		report = new ExtentReports(path);

	}

	@AfterSuite
	public void closeReport() {

		report.flush();
	}

	@BeforeMethod
	public void report() {

		logger = report.startTest("Login to Entriprise edition");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			logger.log(LogStatus.FAIL, logger.addScreenCapture(Helper.captureScreenShot(driver)));

		}

		report.endTest(logger);
	}

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");

		driver.manage().window().maximize();

	}

	@AfterClass
	public void closeBrowser() {

		driver.quit();
	}

	@Test
	public void testDB() throws ClassNotFoundException, SQLException, InterruptedException {

		Class.forName("com.mysql.jdbc.Driver");

		System.out.println("Driver loaded");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium", "root", "Mohan");

		System.out.println("Connected to MySQL DB");

		Statement smt = con.createStatement();

		ResultSet rs = smt.executeQuery("select * from seleniumuser");

		while (rs.next()) {

			String uname = rs.getString("username");

			driver.findElement(By.id("txtUsername")).sendKeys(uname);

			String pass = rs.getString("password");

			driver.findElement(By.id("txtPassword")).sendKeys(pass);
			
			System.out.println(uname + " " + pass);
			
			Helper.captureScreenShot(driver);

			driver.findElement(By.id("btnLogin")).click();

			WebElement partial = driver.findElement(By.partialLinkText("Welcome"));

			WebDriverWait wait = new WebDriverWait(driver, 10);

			wait.until(ExpectedConditions.visibilityOf(partial));

			try {
				status = partial.isDisplayed();

				partial.click();

				Thread.sleep(500);

				driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

			} catch (Exception e) {

				Assert.assertTrue(status);
			}

		}

	}

}
