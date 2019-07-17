/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.Helper;

/**
 * @author Lenovo
 *
 */
public class LogOutPage {

	WebDriver driver;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Welcome")
	WebElement welcomeButton;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Logout')]")
	WebElement logoutButton;
	
	public LogOutPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	public void logOutApp(){
		
		Helper.waitForElement(driver, welcomeButton).click();
		
		Helper.waitForElement(driver, logoutButton).click();
		
		
	}
	
}
