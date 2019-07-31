/**
 * 
 */
package demo;

import java.util.concurrent.TimeUnit;

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
public class Actions_Demo1 {

	@Test
	public void test() {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");

		WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
		
		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='u_0_2']"));

		Actions act = new Actions(driver);

		act.moveToElement(username).click().sendKeys(username, "Mohan").build().perform();
		
		act.moveToElement(password).click().sendKeys(password, "123").doubleClick().contextClick().build().perform();

//		act.moveToElement(loginButton).click().build().perform();
	}

}
