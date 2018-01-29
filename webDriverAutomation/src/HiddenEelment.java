import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HiddenEelment {
	
	
	WebDriver driver;
	@Test(enabled=true)
	public void fileUploadWithAutoIt() throws AWTException{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/WBL/Desktop/hiddensample.html");//give ur system locator
		
		WebElement element = driver.findElement(By.id("myInputHidden"));
		System.out.println("is hidden or not : "+element.isDisplayed());
		Assert.assertFalse(element.isDisplayed());
		Point point =element.getLocation();
		Assert.assertTrue(point.x==0);
		System.out.println("location for hidden  :"+ point.x);
		
		element = driver.findElement(By.id("myInput"));
		System.out.println("is hidden or not : "+element.isDisplayed());
		Assert.assertTrue(element.isDisplayed());
		
		point =element.getLocation();
		Assert.assertTrue(point.x!=0);
		System.out.println("location for not  hidden  :"+ point.x);
		
		
	}


}
