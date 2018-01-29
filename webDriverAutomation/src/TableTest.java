import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TableTest {
	WebDriver driver;
	@Test(enabled=true)
	public void fileUploadWithAutoIt() throws AWTException{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("resources/chromedriver"));
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/WBL/Desktop/tables.html");
		List<WebElement> elements=driver.findElements(By.cssSelector("#mytable>tbody>tr>th"));
		Assert.assertEquals("Company", elements.get(0).getText());
		Assert.assertEquals("Contact", elements.get(1).getText());
		Assert.assertEquals("Country", elements.get(2).getText());
		for(WebElement elm : elements){
			System.out.println(elm.getText());
			Assert.assertNotNull(elm.getText());
		}
		
		
		elements=driver.findElements(By.cssSelector("#mytable>tbody>tr>td:nth-of-type(1)"));
		for(WebElement elm : elements){
			System.out.println(elm.getText());
			Assert.assertNotNull(elm.getText());
		}
		
		
	}
}


