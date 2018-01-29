import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class JavaScriprExecutor {
	WebDriver driver;
	
	@Test
	public void javascriptExecutor() throws AWTException, InterruptedException{
		// script to check if page is loaded completely
		((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		
		System.setProperty("webdriver.chrome.driver","resources/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.walmart.com/");
		//driver.findElement(By.id("global-search-input")).sendKeys("laptop");
		WebElement element = (WebElement)((JavascriptExecutor)driver).executeScript("return document.getElementById('global-search-input')");
		element.sendKeys("Laptop");
		Robot robot = new Robot();
		//robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		// return  web element
		((JavascriptExecutor)driver).executeScript("return document.getElementsByClassName('.footer-GlobalSocialIcons')");
		
		//return webelement and get text of element
		//System.out.println(element.get(0).getText());
		
		Thread.sleep(2000);
		
		((JavascriptExecutor)driver).executeScript("alert('hello')");
		
		//((JavascriptExecutor)driver).executeScript("window.scrollBy(0,900)");
	}
	

}



