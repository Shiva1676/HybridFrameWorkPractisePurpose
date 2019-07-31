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
public class ActionsClass_KeysConcepts {

	@Test
	public void test(){
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://www.uitestpractice.com/Students/Actions");

		WebElement ele = driver.findElement(By.xpath("//button[@name='click']"));
		
		Actions act = new Actions(driver);
		

		
	}
	
	
}
