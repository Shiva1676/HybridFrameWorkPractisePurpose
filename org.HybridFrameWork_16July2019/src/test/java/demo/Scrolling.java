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
import org.testng.annotations.Test;

/**
 * @author Lenovo
 *
 */
public class Scrolling {

	@Test
	public void verifyContentThroughScrolling() {

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");

		// Create a instance of javaScriptExecutor

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Identify the webElement

		WebElement element = driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/p[3]"));

		// js.executeScript("arguments[0].scrollIntoView(true);",element);

		js.executeScript("arguments[0].scrollIntoView(true);", element);

		// Extract the text and verify

		System.out.println(element.getText());
	}

}
