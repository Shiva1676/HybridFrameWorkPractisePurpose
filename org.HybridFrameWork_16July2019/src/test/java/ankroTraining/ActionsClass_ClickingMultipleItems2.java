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
public class ActionsClass_ClickingMultipleItems2 {

	@Test
	public void test(){
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.uitestpractice.com/Students/Actions");
		
		WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Widgets')]"));
		WebElement ele1 = driver.findElement(By.xpath("//a[contains(text(),'Select')]"));
		
		Actions act = new Actions(driver);
		
//		act.click(ele).build().perform();
		
//		act.clickAndHold(ele).release(ele1).click()..build().perform();
		
//		act.clickAndHold(ele).release(ele1).build().perform();
		
//		act.moveToElement(ele).clickAndHold().moveToElement(ele1).release().click().build().perform();
		
		act.moveToElement(ele).clickAndHold(ele).moveToElement(ele1).clickAndHold(ele).release().build().perform();
		
		System.out.println(driver.getCurrentUrl()+ " "+driver.getTitle());
		
		
	}

}
