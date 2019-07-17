/**
 * 
 */
package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author Lenovo
 *
 */
public class ScrollingOnFlipkart {
	WebDriver driver;

	@Parameters("browser")
	@Test
	public void ScrollingFlipkartApplication(String browsername) throws InterruptedException {

		if (browsername.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		} else if (browsername.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();

			driver.manage().window().maximize();

			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		} else if (browsername.equalsIgnoreCase("IE")) {

			driver = new InternetExplorerDriver();

			driver.manage().window().maximize();

			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		}

		driver.get("https://www.flipkart.com/");

		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();

		WebElement search = driver.findElement(By.xpath(".//input[@name= 'q']"));

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.visibilityOf(search)).sendKeys("Mobiles");

		driver.findElement(By
				.xpath("//body/div[@id='container']/div/div[@class='_3ybBIU']/div[@class='_1tz-RS']/div[@class='_3pNZKl']/div[@class='Y5-ZPI']/form[@class='_1WMLwI header-form-search']/div[@class='col-12-12 _2tVp4j']/button[@class='vh79eN']/*[1]"))
				.click();

		Thread.sleep(1000);

		WebElement ele_Scroll = driver.findElement(By.xpath("//a[@class='_2Xp0TH'][contains(text(),'2')]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true)", ele_Scroll);

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)");

		/*
		 * WebElement OfferZone =
		 * driver.findElement(By.xpath(".//*[text()= 'Offer Zone']"));
		 * 
		 * wait.until(ExpectedConditions.visibilityOf(OfferZone)).isDisplayed();
		 */

		// Get the text

		System.out.println("The text of the click element is:" + ele_Scroll.getText());

		ele_Scroll.click();

	}

}
