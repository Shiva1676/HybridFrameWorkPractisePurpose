/**
 * 
 */
package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

/**
 * @author Lenovo
 *
 */
public class IEBrowser {

	@Test
	public void verifyIEBrowser(){
		
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Lenovo\\Downloads\\MicrosoftWebDriver.exe");
		
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/#downloads");
	}
	
}
