/**
 * 
 */
package demo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author Lenovo
 *
 */
public class SwitchingTabs {

	@Test
	public void verifySwitching() {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		driver.get("https://www.naukri.com/");

		String parentWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();

		for (String childWindow : allWindows) {

			if (!parentWindow.equals(childWindow)) {

				driver.switchTo().window(childWindow);

				String url = driver.getCurrentUrl();

				/*
				 * https: // company.naukri.com/popups/lnt/1072019/index.html
				 * https: // company.naukri.com/popups/tmi/1272019/index.html
				 * https: // company.naukri.com/popups/amazon/1272019/index.html
				 * 
				 */
				if (url.equalsIgnoreCase(
						"https: // company.naukri.com/popups/tmi/1272019/index.html && https: // company.naukri.com/popups/amazon/1272019/index.html")) {

					driver.switchTo().window(childWindow);

					driver.close();
				}

			}

		}

		driver.switchTo().window(parentWindow);

		System.out.println(driver.getCurrentUrl());
	}

}
