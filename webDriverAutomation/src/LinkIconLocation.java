import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LinkIconLocation {

	 static WebDriver driver;

	
	@BeforeClass
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver","resources/chromedriver");
		driver = new ChromeDriver();
		 
		
	}
	
	@Test
	
	public void getLocationTwitter(){
		driver.get("http://whiteboxqa.com/");
		List<WebElement> element = driver.findElements(By.cssSelector(".fa.fa-twitter"));
		for (WebElement ele: element){
			Point point= ele.getLocation();
			System.out.println("Axis of x:"+point.x);
			System.out.println("Axis of Y:"+point.y);
			
		}
		
		
		
	}
	
	/*public void windowHandle(){
		driver.get("http://whiteboxqa.com/");
		System.out.println("Page Title:"+driver.getCurrentUrl());

	}*/
}
