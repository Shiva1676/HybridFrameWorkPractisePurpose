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
public class LoginPage {

	WebDriver driver;

	@FindBy(how = How.ID, using = "txtUsername")
	WebElement username;

	@FindBy(how = How.ID, using = "txtPassword")
	WebElement password;

	@FindBy(how = How.ID, using = "btnLogin")
	WebElement loginButton;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Welcome")
	WebElement Welcome;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Logout')]")
	WebElement logout;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	public boolean loginPage(String uname, String pass) {

		boolean status = false;

		Helper.waitForElement(driver, username).sendKeys(uname);

		System.out.println("Username is:" + uname);

		Helper.waitForElement(driver, password).sendKeys(pass);

		System.out.println("Password is:" + pass);

		Helper.waitForElement(driver, loginButton).click();

		try {

			status = Helper.waitForElement(driver, Welcome).isDisplayed();

		} catch (Exception e) {
			System.out.println("Element not found");
		}

		return status;
	}

}
