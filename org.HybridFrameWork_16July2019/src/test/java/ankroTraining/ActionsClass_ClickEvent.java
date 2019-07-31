/**
 * 
 */
package ankroTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * @author Lenovo
 *
 */
public class ActionsClass_ClickEvent {

	@Test
	public void test() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		
		WebElement submitButton = driver.findElement(By.id("btnLogin"));
		
		Actions act = new Actions(driver);
		
		act.click(submitButton).build().perform();

		WebElement msg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
		
		String text = msg.getAttribute("innerHTML");
		
		System.out.println(text);
		
		Thread.sleep(4000);
		
		driver.quit();
		
	}

}
