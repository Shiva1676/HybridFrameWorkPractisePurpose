/**
 * 
 */
package advanceActivities;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author Lenovo
 *
 */
public class ManageBrowser {

	// Minimize and FullScreen of browser Window
	// Set and get the position and size of browser window
	@Test
	public void test() {

		WebDriver driver = new ChromeDriver();

		driver.get("http://ankpro.com");

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		System.out.println(driver.getPageSource());
		
		driver.quit();

	}
	@Test
	public void test1() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("http://ankpro.com");
		
//		driver.manage().window().fullscreen();
		
//		Thread.sleep(4000);
		
//		driver.manage().window().maximize();
		
//		Thread.sleep(4000);
		
		/*
		 * Point point = driver.manage().window().getPosition();
		 * 
		 * Point x = point.moveBy(200, 400);
		 */
		
		
		driver.manage().window().setPosition(new Point(400,200));
		
		
		
//		driver.quit();

		/*System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		System.out.println(driver.getPageSource());*/
		
//		Thread.sleep(2000);
//		
//		driver.quit();

	}
}
