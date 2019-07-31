/**
 * 
 */
package ankroTraining;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * @author Lenovo
 *
 */
public class ActionsClass_ClickinMultipleItems {

	@Test
	public void test() {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://www.uitestpractice.com/Students/Actions");

		WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Widgets')]"));

		WebElement ele1 = driver.findElement(By.xpath("//a[contains(text(),'Select')]"));

		WebElement ele2 = driver.findElement(By.xpath("//a[contains(text(),'Switch to')]"));

		Actions act = new Actions(driver);

		act.keyDown(Keys.CONTROL).click(ele).click(ele1).click(ele2).keyUp(Keys.CONTROL).build().perform();

		String parentID = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();

		for (String child : allWindows) {

			if (!parentID.equalsIgnoreCase(child)) {

				driver.switchTo().window(child);

				System.out.println(driver.getCurrentUrl());

			}
		}
		driver.switchTo().window(parentID);

		System.out.println(driver.getCurrentUrl());

//		driver.quit();
	}

}
