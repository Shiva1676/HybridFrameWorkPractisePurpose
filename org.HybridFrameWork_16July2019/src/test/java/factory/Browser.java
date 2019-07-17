/**
 * 
 */
package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author Lenovo
 *
 */
public class Browser {

	static WebDriver driver;

	public static WebDriver startBrowser(String browser, String url) {

		if (browser.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();
			
			driver.manage().window().maximize();

			System.out.println("The following browser is up and running in:" + browser);

		} else if (browser.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();

			System.out.println("The following browser is up and running in:" + browser);

		} else if (browser.equalsIgnoreCase("IE")) {

			driver = new InternetExplorerDriver();
			
			driver.manage().window().maximize();

			System.out.println("The following browser is up and running in:" + browser);
		}

		driver.get(url);
		
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		return driver;
	}

}
