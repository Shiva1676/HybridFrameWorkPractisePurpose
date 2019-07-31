/**
 * 
 */
package ankroTraining;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author Lenovo
 *
 */
public class ScreenshotDemo {

	@Test
	public void test() throws IOException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.google.com/");

		WebElement ele = driver.findElement(By.xpath("//img[@id='hplogo']"));

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		BufferedImage fullImg = ImageIO.read(src);

		Point point = ele.getLocation();

		int ele_width = ele.getSize().getWidth();

		int ele_Height = ele.getSize().getHeight();

		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), ele_width, ele_Height);

		ImageIO.write(eleScreenshot, "png", src);

		String path = System.getProperty("user.dir") + "/Screenshots/Google" + System.currentTimeMillis() + ".png";

		File dest = new File(path);

		FileUtils.copyFile(src, dest);
		
		System.out.println(driver.getTitle());
		
//		driver.quit();

	}
}
