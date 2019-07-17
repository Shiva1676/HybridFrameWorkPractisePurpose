/**
 * 
 */
package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Lenovo
 *
 */
public class Helper {

	public static WebElement waitForElement(WebDriver driver, WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, 5);

		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));

		return element;
	}

	public static String captureScreenShot(WebDriver driver) {

		String path = System.getProperty("user.dir") + "/Screenshots/HRM" + System.currentTimeMillis() + ".png";

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		File dest = new File(path);

		try {

			FileUtils.copyFile(src, dest);

		} catch (IOException e) {
			System.out.println("Unable to capture screenshots");

			System.out.println(e.getMessage());
		}

		return path;
	}

}
