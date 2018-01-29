import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class CaptureScreen {
	
	
	@Test	

	public void facebookscreenshot() {
		
		WebDriver driver;

	System.setProperty("webdriver.chrome.driver","resources/chromedriver");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.facebook.com/");
	
	driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("Hello");
	
	try
	{
	TakesScreenshot ts =(TakesScreenshot)driver;
	//System.out.println("ScreenShotTaken1");
	
		File source=ts.getScreenshotAs(OutputType.FILE);
	
		System.out.println("ScreenShotTaken2");
		
		String dest = "/Users/Praween/Documents/Javacode/webDriverAutomation/Screenshot/" + "facebook.png";
		
		File destination = new File(dest);
	
		FileUtils.copyFile(source, destination);
		
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	System.out.println("ScreenShotTaken");
	driver.close();
	

}
}



