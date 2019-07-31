/**
 * 
 */
package ankroTraining;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * @author Lenovo
 *
 */
public class ActionsClass_DoubleClick {

	@Test
	public void test() {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://www.uitestpractice.com/Students/Actions");

		WebElement ele = driver.findElement(By.xpath("//button[@name='dblClick']"));

		Actions act = new Actions(driver);

		act.doubleClick(ele).perform();

		try {
			Alert alert = driver.switchTo().alert();

			alert.accept();

		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block

			System.out.println(e.getMessage());

			System.out.println("No alert is present");
		}
		
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getTitle());
	}

}
